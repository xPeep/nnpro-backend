package cz.edu.upce.fei.nnpro.repository

import cz.edu.upce.fei.nnpro.model.TrainRoute
import org.springframework.data.jpa.repository.JpaRepository

interface TrainRouteRepository : JpaRepository<TrainRoute, Long>
