package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.SubstituteRouteSection
import cz.edu.upce.fei.nnpro.repository.SubstituteRouteSectionRepository
import org.springframework.stereotype.Service

@Service
class SubstituteRouteSectionService(
    private val substituteRouteSectionRepository: SubstituteRouteSectionRepository
) {
    fun save(substituteRouteSection: SubstituteRouteSection) =
        substituteRouteSectionRepository.save(substituteRouteSection)

    fun getById(id: Long) = substituteRouteSectionRepository.getById(id)

    fun getAll(): List<SubstituteRouteSection> = substituteRouteSectionRepository.findAll()

    fun delete(substituteRouteSection: SubstituteRouteSection) =
        substituteRouteSectionRepository.delete(substituteRouteSection)
}
