package cz.edu.upce.fei.nnpro.model

import cz.edu.upce.fei.nnpro.dto.RegionDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
class Region(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var name: String = "",
    @Size(max = 3)
    var code: String = ""
    //TODO add coordinates, zoom for view in map
) {
    fun toDto() = RegionDto(id, name, code)
}
