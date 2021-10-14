package cz.edu.upce.fei.nnpro.model

import javax.persistence.*

@Entity
class SubstituteRoute(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = Long.MIN_VALUE,
    val name: String = "",
    @OneToOne
    @JoinColumn(name = "train_route_id")
    val concernedTrainRoute: TrainRoute? = null
)
