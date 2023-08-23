package io.bg.workshop.kotlin.restapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestappApplication

fun main(args: Array<String>) {
	runApplication<RestappApplication>(*args)
}
