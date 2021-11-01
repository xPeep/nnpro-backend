package cz.edu.upce.fei.nnpro.controller

import cz.edu.upce.fei.nnpro.dto.ResponseDto
import cz.edu.upce.fei.nnpro.model.Rail
import cz.edu.upce.fei.nnpro.service.RailService
import org.springframework.http.ResponseEntity
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rail")
class RailController(
	val railService: RailService
) {
	@GetMapping("/{id}")
	fun detail(@PathVariable id: Long): ResponseEntity<Any> {
		return try {
			ResponseEntity.ok(railService.getById(id))
		} catch (e: JpaObjectRetrievalFailureException) {
			ResponseEntity.status(542).body(ResponseDto("Rail with id $id not found!"))
		}
	}

	@GetMapping
	fun listAll(): List<Rail> = railService.getAll()

	@PostMapping
	fun save(@RequestBody rail: Rail) = railService.save(rail)

	@DeleteMapping
	fun delete(@RequestBody rail: Rail) = railService.delete(rail)

	@DeleteMapping("/{id}")
	fun deleteById(@PathVariable id: Long) = railService.deleteById(id)
}
