package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.TrainRoute

class TrainRouteDto(
    var id: Long = Long.MIN_VALUE,
    var trainCode: String = "",
    var closure: Boolean = false
) {
    fun toModel() = TrainRoute(id, trainCode, closure)
}
