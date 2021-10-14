package cz.edu.upce.fei.nnpro.model

import javax.persistence.*

@Entity
@Table(name = "train_route_section")
class TrainRouteSection(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rail_id")
    var rail: Rail? = null,
    @OneToOne
    var trainRoute: TrainRoute? = null,
    var routeOrder: Int = Int.MIN_VALUE
)
