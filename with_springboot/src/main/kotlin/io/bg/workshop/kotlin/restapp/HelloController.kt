package io.bg.workshop.kotlin.restapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/hello")
class HelloController {

//    @GetMapping("world/{id}")
//    fun helloById(@PathVariable id:String?): String {
//        return "Hello world - $id"
//    }
//
//    @GetMapping("world")
//    fun hello(): String {
//        return "Hello world - No id"
//    }

    @GetMapping("")
    fun index() = "Welcome to Hello World"


    @GetMapping("world/{id}")
    fun helloById(@PathVariable id: String?, @RequestParam(required = false) name: String?) = handleHello(id, name)

    @GetMapping("world")
    fun hello(@RequestParam(required = false) name: String?) = handleHello(name = name)

    fun handleHello(id: String? = null, name: String? = null): String {
        return "Hello world - ${id ?: "No ID"} [Param: $name]"
    }
}