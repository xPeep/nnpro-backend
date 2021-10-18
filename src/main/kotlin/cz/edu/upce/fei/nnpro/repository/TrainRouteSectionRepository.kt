package cz.edu.upce.fei.nnpro.repository

import cz.edu.upce.fei.nnpro.model.TrainRouteSection
import org.springframework.data.jpa.repository.JpaRepository

interface TrainRouteSectionRepository : JpaRepository<TrainRouteSection, Long>
