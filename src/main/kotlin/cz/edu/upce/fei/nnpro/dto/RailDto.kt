package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.Rail
import cz.edu.upce.fei.nnpro.model.Station

class RailDto(
    var id: Long = Long.MIN_VALUE,
    var code: String = "",
    var name: String = "",
    var sourceStationId: Long = Long.MIN_VALUE,
    var targetStationId: Long = Long.MIN_VALUE,
    var enabled: Boolean = true
) {
    fun toModel(fetchStation: (id: Long) -> Station?) =
        Rail(id, code, name, fetchStation(sourceStationId), fetchStation(targetStationId), enabled)
}
