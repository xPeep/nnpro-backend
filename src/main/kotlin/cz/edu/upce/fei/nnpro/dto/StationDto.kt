package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.Region
import cz.edu.upce.fei.nnpro.model.Station

class StationDto(
    var id: Long = Long.MIN_VALUE,
    var code: String = "",
    var name: String = "",
    var regionId: Long = Long.MIN_VALUE,
    val x: Double = 0.0,
    val y: Double = 0.0
) {
    fun toModel(fetchRegion: (id: Long) -> Region?) =
        Station(id, code, name, fetchRegion(regionId), x, y)
}
