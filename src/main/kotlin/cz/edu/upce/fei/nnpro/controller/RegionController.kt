package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.model.Region
import cz.edu.upce.fei.nnpro.service.RegionService
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/region")
class RegionController(
    val regionService: RegionService
) {
    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(regionService.getById(id))
        } catch (e: JpaObjectRetrievalFailureException) {
            ResponseEntity.status(542).body(ResponseDto("Region with id $id not found!"))
        }
    }

    @GetMapping
    fun listAll(): List<Region> = regionService.getAll()

    @PostMapping
    fun save(@RequestBody region: Region) = regionService.save(region)

    @DeleteMapping
    fun delete(@RequestBody region: Region) = regionService.delete(region)
}
