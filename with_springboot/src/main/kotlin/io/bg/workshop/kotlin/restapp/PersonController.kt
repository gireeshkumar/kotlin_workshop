package io.bg.workshop.kotlin.restapp

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/person")
class PersonController {

    val persons: MutableList<Person> = mutableListOf()

    @GetMapping
    fun index() = persons

    @PostMapping
    fun create(@RequestBody person: Person): Person {
        println("Create Person $person")
        person.uid = UUID.randomUUID().toString()
        persons.add(person);
        return person;
    }

//    @PutMapping("{uid}")
//    fun update(@PathVariable uid: String, @RequestBody person: Person): ResponseEntity<Person>? {
//        var found: Person? = persons.find { it.uid == uid }
//        if (found != null) {
//            found.name = person.name
//            found.age = person.age
//        } else {
//            return ResponseEntity(HttpStatus.NOT_FOUND)
//        }
//        return ResponseEntity(found, HttpStatus.OK)
//    }

    @PutMapping("{uid}")
    fun update(@PathVariable uid: String, @RequestBody person: Person): ResponseEntity<Person>? {
//        val found = persons.firstOrNull { it.uid == uid }
//        return when (found) {
//            null -> ResponseEntity(HttpStatus.NOT_FOUND)
//            else -> {
//                found.apply {
//                    name = person.name
//                    age = person.age
//                }
//                ResponseEntity(found, HttpStatus.OK)
//            }
//        }
        val found = persons.find { it.uid == uid } ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        found.apply {
            name = person.name
            age = person.age
        }

        return ResponseEntity(found, HttpStatus.OK)
    }


    @GetMapping("{uid}")
    fun byId(@PathVariable uid: String) = persons.filter { it.uid == uid }

    @DeleteMapping("{uid}")
    fun delete(@PathVariable uid: String) = persons.removeIf { it.uid == uid }
}