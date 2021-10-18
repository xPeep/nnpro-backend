package cz.edu.upce.fei.nnpro.model

import cz.edu.upce.fei.nnpro.dto.IncidentDto
import java.text.SimpleDateFormat
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
) {
    fun toDto() = IncidentDto(
        id, name, description, severity.name, affectedRail?.id ?: Long.MIN_VALUE,
        dateFormat.format(startDate), if (endDate != null) dateFormat.format(endDate) else null,
        reportedBy?.id ?: Long.MIN_VALUE
    )

    companion object {
        val dateFormat = SimpleDateFormat("MM-dd-yyyy HH:mm:ss.SSS")
    }
}
