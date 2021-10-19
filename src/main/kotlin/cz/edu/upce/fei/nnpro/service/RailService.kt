package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.Rail
import cz.edu.upce.fei.nnpro.repository.RailRepository
import org.springframework.stereotype.Service

@Service
class RailService(
    private val railRepository: RailRepository
) {
    fun save(rail: Rail) = railRepository.save(rail)

    fun getById(id: Long) = railRepository.getById(id)

    fun getAll(): List<Rail> = railRepository.findAll()

    fun delete(rail: Rail) = railRepository.delete(rail)
}
