package cz.edu.upce.fei.nnpro.model

import javax.persistence.*

@Entity
class Rail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var code: String = "",
    var name: String = "",
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "source_station_id")
    var sourceStation: Station? = null,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "target_station_id")
    var targetStation: Station? = null,
    var enabled: Boolean = true
)
