package cz.edu.upce.fei.nnpro.repository

import cz.edu.upce.fei.nnpro.model.Incident
import org.springframework.data.jpa.repository.JpaRepository

interface IncidentRepository : JpaRepository<Incident, Long>
