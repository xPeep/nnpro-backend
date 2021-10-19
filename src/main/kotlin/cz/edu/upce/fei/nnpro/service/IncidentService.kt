package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.Incident
import cz.edu.upce.fei.nnpro.repository.IncidentRepository
import org.springframework.stereotype.Service

@Service
class IncidentService(
    private val incidentRepository: IncidentRepository
) {
    fun save(incident: Incident) = incidentRepository.save(incident)

    fun getById(id: Long) = incidentRepository.getById(id)

    fun getAll(): List<Incident> = incidentRepository.findAll()

    fun delete(incident: Incident) = incidentRepository.delete(incident)
}
