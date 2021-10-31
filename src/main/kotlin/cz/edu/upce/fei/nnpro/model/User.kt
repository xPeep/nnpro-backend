package cz.edu.upce.fei.nnpro.model

import cz.edu.upce.fei.nnpro.dto.UserDto
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(
    name = "users",
    uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("username")), UniqueConstraint(columnNames = arrayOf("email"))]
)
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var username: @NotBlank @Size(max = 20) String = "",
    var email: @NotBlank @Size(max = 50) @Email String = "",
    var password: @NotBlank @Size(max = 120) String = "",
    @Enumerated(EnumType.STRING)
    var role: Role = Role.ROLE_USER,
    @Enumerated(EnumType.STRING)
    var userGroup: UserGroup = UserGroup.NONE
) {
    fun toDto() = UserDto(id, username, email, "", role.name, userGroup.name)
}
