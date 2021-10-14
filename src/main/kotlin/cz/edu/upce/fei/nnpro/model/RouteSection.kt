package cz.edu.upce.fei.nnpro.model

import javax.persistence.*

@Entity
@Table(name = "route_section")
class RouteSection(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "track_id")
    var track: Rail? = null,
    @OneToOne
    var trainRoute: TrainRoute? = null,
    var routeOrder: Int = Int.MIN_VALUE
)
