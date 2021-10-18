package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.Station
import cz.edu.upce.fei.nnpro.model.SubstituteRoute
import cz.edu.upce.fei.nnpro.model.SubstituteRouteSection

class SubstituteRouteSectionDto(
    var id: Long = Long.MIN_VALUE,
    var stationId: Long = Long.MIN_VALUE,
    var substituteRouteId: Long = Long.MIN_VALUE,
    var routeOrder: Int = Int.MIN_VALUE
) {
    fun toModel(fetchStation: (id: Long) -> Station?, fetchSubstituteRoute: (id: Long) -> SubstituteRoute?) =
        SubstituteRouteSection(id, fetchStation(stationId), fetchSubstituteRoute(substituteRouteId), routeOrder)
}
