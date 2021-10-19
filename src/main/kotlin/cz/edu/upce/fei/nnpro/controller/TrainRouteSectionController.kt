package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.model.TrainRouteSection
import cz.edu.upce.fei.nnpro.service.TrainRouteSectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/train-route-section")
class TrainRouteSectionController(
    @Autowired val trainRouteSectionService: TrainRouteSectionService
) {
    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(trainRouteSectionService.getById(id))
        } catch (e: JpaObjectRetrievalFailureException) {
            ResponseEntity.status(542).body(ResponseDto("Train route with id $id not found!"))
        }
    }

    @GetMapping
    fun listAll(): List<TrainRouteSection> = trainRouteSectionService.getAll()

    @PostMapping
    fun save(@RequestBody trainRouteSection: TrainRouteSection) = trainRouteSectionService.save(trainRouteSection)

    @DeleteMapping
    fun delete(@RequestBody trainRouteSection: TrainRouteSection) = trainRouteSectionService.delete(trainRouteSection)
}
