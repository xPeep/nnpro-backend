package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.JwtResponseDto
import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.dto.UserDto
import cz.edu.upce.fei.nnpro.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpHeaders
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController(
    @Autowired val userService: UserService
) {

    @PostMapping("/login")
    fun login(@RequestBody userDto: UserDto): ResponseEntity<JwtResponseDto> {
        val jwtResponse = userService.login(userDto)
        return ResponseEntity.ok()
            .headers(HttpHeaders().apply { set("authorization", "Bearer ${jwtResponse.accessToken}") })
            .body(jwtResponse)
    }

    @PostMapping("/register")
    fun register(@RequestBody userDto: UserDto): ResponseEntity<ResponseDto> {
        return ResponseEntity.ok(userService.register(userDto))
    }

    @GetMapping("/details")
    fun detail(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userService.getLoggedUser())
        } catch (e: JpaObjectRetrievalFailureException) {
            ResponseEntity.status(542).body(ResponseDto("User not logged!"))
        }
    }

    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userService.getById(id))
        } catch (e: JpaObjectRetrievalFailureException) {
            ResponseEntity.status(542).body(ResponseDto("User with id $id not found!"))
        }
    }

}
