package cz.edu.upce.fei.nnpro.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class TrainRoute(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var trainCode: String = "",
    //TODO asi nebude potreba, stacil by check, jestli jsou nejake Incidenty
    var closure: Boolean = false
)
