package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.SubstituteRoute
import cz.edu.upce.fei.nnpro.model.TrainRoute

class SubstituteRouteDto(
    var id: Long = Long.MIN_VALUE,
    var name: String = "",
    var concernedTrainRouteId: Long = Long.MIN_VALUE,
) {
    fun toModel(fetchTrainRoute: (id: Long) -> TrainRoute?) =
        SubstituteRoute(id, name, fetchTrainRoute(concernedTrainRouteId))
}
