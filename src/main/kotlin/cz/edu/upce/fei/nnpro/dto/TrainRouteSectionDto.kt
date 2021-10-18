package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.*

class TrainRouteSectionDto(
    var id: Long = Long.MIN_VALUE,
    var railId: Long = Long.MIN_VALUE,
    var trainRouteId: Long = Long.MIN_VALUE,
    var routeOrder: Int = Int.MIN_VALUE
) {
    fun toModel(fetchRail: (id: Long) -> Rail?, fetchTrainRoute: (id: Long) -> TrainRoute?) =
        TrainRouteSection(id, fetchRail(railId), fetchTrainRoute(trainRouteId), routeOrder)
}