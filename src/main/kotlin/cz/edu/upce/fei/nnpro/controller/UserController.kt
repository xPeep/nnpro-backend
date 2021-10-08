package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.JwtResponseDto
import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.dto.UserDto
import cz.edu.upce.fei.nnpro.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController(
    @Autowired val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody userDto: UserDto): ResponseEntity<JwtResponseDto> {
        return ResponseEntity.ok(userService.login(userDto))
    }

    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<ResponseDto> {
        return ResponseEntity.ok(userService.register(userDto))
    }

}
