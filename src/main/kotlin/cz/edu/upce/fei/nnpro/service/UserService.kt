package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.dto.JwtResponseDto
import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.dto.UserDto
import cz.edu.upce.fei.nnpro.model.Role
import cz.edu.upce.fei.nnpro.repository.UserRepository
import cz.edu.upce.fei.nnpro.security.jwt.JwtUtils
import cz.edu.upce.fei.nnpro.security.service.UserDetailsImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var encoder: PasswordEncoder

    @Autowired
    private lateinit var jwtUtils: JwtUtils


    fun login(userDto: UserDto): JwtResponseDto {
        val authentication = authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(userDto.username, userDto.password)
        )

        SecurityContextHolder.getContext().authentication = authentication
        val jwt = jwtUtils.generateJwtToken(authentication)
        val userDetails = authentication.principal as UserDetailsImpl
        val role = userDetails.authorities.first().authority

        return JwtResponseDto(
            userDetails.id, userDetails.username, userDetails.email, role, jwt
        )
    }

    fun register(userDto: UserDto): ResponseDto {
        if (userRepository.existsByUsername(userDto.username)) {
            return ResponseDto("Error: Username is already taken!")
        }

        if (userRepository.existsByEmail(userDto.email)) {
            return ResponseDto("Error: Email is already in use!")
        }

        val user = userDto.toModel().apply {
            password = encoder.encode(userDto.password)
            role = Role.ROLE_USER
        }

        userRepository.save(user)
        return ResponseDto("User registered successfully!")
    }

}
