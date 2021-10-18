package cz.edu.upce.fei.nnpro.repository

import cz.edu.upce.fei.nnpro.model.Rail
import org.springframework.data.jpa.repository.JpaRepository

interface RailRepository : JpaRepository<Rail, Long>
