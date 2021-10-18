package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.Region

class RegionDto(
    var id: Long = Long.MIN_VALUE,
    var name: String = "",
    var code: String = ""
) {
    fun toModel() = Region(id, code, name)
}
