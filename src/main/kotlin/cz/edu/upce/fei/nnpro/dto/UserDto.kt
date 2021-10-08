package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.Role
import cz.edu.upce.fei.nnpro.model.User

class UserDto(
    var id: Long = Long.MIN_VALUE,
    var username: String = "",
    var email: String = "",
    var password: String = "",
    val role: String = Role.ROLE_USER.name,
) {
    fun toModel() = User(id, username, email, password, Role.valueOf(role))
}
