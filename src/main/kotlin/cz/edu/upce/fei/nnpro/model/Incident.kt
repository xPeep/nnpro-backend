package cz.edu.upce.fei.nnpro.model

import javax.persistence.*

@Entity
class Incident(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var name: String = "",
    var description: String = "",
    @Enumerated(EnumType.STRING)
    var severity: IncidentSeverity = IncidentSeverity.MINOR,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "affected_rail_id")
    var affectedRail: Rail? = null
)
