package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.TrainRoute
import cz.edu.upce.fei.nnpro.repository.TrainRouteRepository
import org.springframework.stereotype.Service

@Service
class TrainRouteService(
    private val trainRouteRepository: TrainRouteRepository
) {
    fun save(trainRoute: TrainRoute) = trainRouteRepository.save(trainRoute)

    fun getById(id: Long) = trainRouteRepository.getById(id)

    fun getAll(): List<TrainRoute> = trainRouteRepository.findAll()

    fun delete(trainRoute: TrainRoute) = trainRouteRepository.delete(trainRoute)
}
