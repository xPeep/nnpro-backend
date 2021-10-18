package cz.edu.upce.fei.nnpro.repository

import cz.edu.upce.fei.nnpro.model.Region
import org.springframework.data.jpa.repository.JpaRepository

interface RegionRepository : JpaRepository<Region, Long>
