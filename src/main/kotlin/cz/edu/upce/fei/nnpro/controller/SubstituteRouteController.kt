package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.model.SubstituteRoute
import cz.edu.upce.fei.nnpro.service.SubstituteRouteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/substitute-route")
class SubstituteRouteController(
    @Autowired val substituteRouteService: SubstituteRouteService
) {
    @GetMapping("/{id}")
    fun detail(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(substituteRouteService.getById(id))
        } catch (e: JpaObjectRetrievalFailureException) {
            ResponseEntity.status(542).body(ResponseDto("Substitute route with id $id not found!"))
        }
    }

    @GetMapping
    fun listAll(): List<SubstituteRoute> = substituteRouteService.getAll()

    @PostMapping
    fun save(@RequestBody substituteRoute: SubstituteRoute) = substituteRouteService.save(substituteRoute)

    @DeleteMapping
    fun delete(@RequestBody substituteRoute: SubstituteRoute) = substituteRouteService.delete(substituteRoute)
}
