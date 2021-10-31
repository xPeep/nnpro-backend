package cz.edu.upce.fei.nnpro.dto

class JwtResponseDto(
    var id: Long,
    var username: String,
    var email: String,
    val role: String,
    var accessToken: String,
    var userGroup: String,
    var tokenType: String = "Bearer"
)
