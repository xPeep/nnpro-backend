package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.SubstituteRoute
import cz.edu.upce.fei.nnpro.repository.SubstituteRouteRepository
import org.springframework.stereotype.Service

@Service
class SubstituteRouteService(
    private val substituteRouteRepository: SubstituteRouteRepository
) {
    fun save(substituteRoute: SubstituteRoute) = substituteRouteRepository.save(substituteRoute)

    fun getById(id: Long) = substituteRouteRepository.getById(id)

    fun getAll(): List<SubstituteRoute> = substituteRouteRepository.findAll()

    fun delete(substituteRoute: SubstituteRoute) = substituteRouteRepository.delete(substituteRoute)
}
