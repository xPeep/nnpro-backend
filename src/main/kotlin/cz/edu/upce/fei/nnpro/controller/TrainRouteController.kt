package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.model.TrainRoute
import cz.edu.upce.fei.nnpro.service.TrainRouteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/train-route")
class TrainRouteController(
    @Autowired val trainRouteService: TrainRouteService
) {
    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(trainRouteService.getById(id))
        } catch (e: JpaObjectRetrievalFailureException) {
            ResponseEntity.status(542).body(ResponseDto("Train route with id $id not found!"))
        }
    }

    @GetMapping
    fun listAll(): List<TrainRoute> = trainRouteService.getAll()

    @PostMapping
    fun save(@RequestBody trainRoute: TrainRoute) = trainRouteService.save(trainRoute)

    @DeleteMapping
    fun delete(@RequestBody trainRoute: TrainRoute) = trainRouteService.delete(trainRoute)
}
