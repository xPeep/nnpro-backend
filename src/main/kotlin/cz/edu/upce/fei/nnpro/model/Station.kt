package cz.edu.upce.fei.nnpro.model

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Station(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = Long.MIN_VALUE,
    var code: @NotBlank @Size(max = 5) String = "",
    var name: @NotBlank String = "",
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id")
    var region: Region? = null,
    var x: Double = Double.MIN_VALUE,
    var y: Double = Double.MIN_VALUE,
)
