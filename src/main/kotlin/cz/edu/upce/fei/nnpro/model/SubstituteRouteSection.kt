package cz.edu.upce.fei.nnpro.model

import javax.persistence.*

@Entity
@Table(name = "substitute_route_section")
class SubstituteRouteSection(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "station_id")
    var station: Station? = null,
    @OneToOne
    var substituteRoute: SubstituteRoute? = null,
    var routeOrder: Int = Int.MIN_VALUE
)
