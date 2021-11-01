package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.Incident
import cz.edu.upce.fei.nnpro.repository.IncidentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class IncidentService(
	private val incidentRepository: IncidentRepository,
	private val userService: UserService
) {
	fun save(incident: Incident): Incident {
		incident.reportedBy = userService.getByUsername(SecurityContextHolder.getContext().authentication.name)
		return incidentRepository.save(incident)
	}

	fun getById(id: Long) = incidentRepository.getById(id)

	fun getAll(): List<Incident> = incidentRepository.findAll()

	fun delete(incident: Incident) = incidentRepository.delete(incident)

	fun deleteById(id: Long) = incidentRepository.deleteById(id)
}
