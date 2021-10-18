package cz.edu.upce.fei.nnpro.dto

import cz.edu.upce.fei.nnpro.model.Incident
import cz.edu.upce.fei.nnpro.model.IncidentSeverity
import cz.edu.upce.fei.nnpro.model.Rail
import cz.edu.upce.fei.nnpro.model.User
import java.util.*

class IncidentDto(
    var id: Long = Long.MIN_VALUE,
    var name: String = "",
    var description: String = "",
    var severity: String = IncidentSeverity.MINOR.name,
    var affectedRailId: Long = Long.MIN_VALUE,
    var startDate: String = Incident.dateFormat.format(Date()),
    var endDate: String? = null,
    val reportedById: Long = Long.MIN_VALUE
) {
    fun toModel(fetchRail: (id: Long) -> Rail?, fetchUser: (id: Long) -> User?) =
        Incident(
            id,
            name,
            description,
            IncidentSeverity.valueOf(severity),
            fetchRail(affectedRailId),
            parseDate(startDate),
            if (endDate != null && endDate!!.isNotEmpty()) parseDate(endDate) else null,
            fetchUser(reportedById)
        )

    private fun parseDate(value: String?): Date = Incident.dateFormat.parse(value)
}
