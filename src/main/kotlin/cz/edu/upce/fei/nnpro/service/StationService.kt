package cz.edu.upce.fei.nnpro.service

import cz.edu.upce.fei.nnpro.model.Station
import cz.edu.upce.fei.nnpro.repository.StationRepository
import org.springframework.stereotype.Service

@Service
class StationService(
    private val stationRepository: StationRepository
) {
    fun save(station: Station) = stationRepository.save(station)

    fun getById(id: Long) = stationRepository.getById(id)

    fun getAll(): List<Station> = stationRepository.findAll()

    fun delete(region: Station) = stationRepository.delete(region)
}
