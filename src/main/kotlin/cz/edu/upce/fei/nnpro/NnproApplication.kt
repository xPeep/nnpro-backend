package cz.edu.upce.fei.nnpro

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NnproApplication

fun main(args: Array<String>) {
    runApplication<NnproApplication>(*args)
}
