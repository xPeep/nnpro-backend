package cz.edu.upce.fei.nnpro.model

import java.util.*
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
    @JoinColumn(name = "rail_id")
    var affectedRail: Rail? = null,
    var startDate: Date = Date(),
    var endDate: Date? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    var reportedBy: User? = null
)
