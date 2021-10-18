package cz.edu.upce.fei.nnpro.model

import cz.edu.upce.fei.nnpro.dto.RailDto
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
) {
    fun toDto(): RailDto {
        return RailDto(
            id, code, name, sourceStation?.id ?: Long.MIN_VALUE,
            targetStation?.id ?: Long.MIN_VALUE, enabled
        )
    }
}
