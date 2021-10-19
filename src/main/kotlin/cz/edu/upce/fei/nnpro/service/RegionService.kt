package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.Region
import cz.edu.upce.fei.nnpro.repository.RegionRepository
import org.springframework.stereotype.Service

@Service
class RegionService(
    private val regionRepository: RegionRepository
) {
    fun save(region: Region) = regionRepository.save(region)

    fun getById(id: Long) = regionRepository.getById(id)

    fun getAll(): List<Region> = regionRepository.findAll()

    fun delete(region: Region) = regionRepository.delete(region)
}
