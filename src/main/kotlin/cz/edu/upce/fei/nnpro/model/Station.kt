package cz.edu.upce.fei.nnpro.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Station(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var code: @NotBlank @Size(max = 5) String = "",
    var name: @NotBlank @Size(max = 5) String = "",
    var xCoordinate: Double = Double.MIN_VALUE,
    var yCoordinate: Double = Double.MIN_VALUE,
)
