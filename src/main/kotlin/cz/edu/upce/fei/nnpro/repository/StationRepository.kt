package cz.edu.upce.fei.nnpro.repository

import cz.edu.upce.fei.nnpro.model.Station
import org.springframework.data.jpa.repository.JpaRepository

interface StationRepository : JpaRepository<Station, Long>
