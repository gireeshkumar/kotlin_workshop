package org.acme

import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.util.UUID

@Path("/person")
class PersonResource {

    val list: MutableList<Person> = mutableListOf();

    @GET
    fun index() = list

    @POST
    fun create(person: Person): Person {
        person.uuid = UUID.randomUUID().toString()
        list.add(person);
        return person
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") uid: String, person: Person): Person {
        val found: Person =
            list.find { it.uuid == uid } ?: throw NotFoundException("Person with ID:$uid doesn't exist")
        found.apply {
            name = person.name
            age = person.age
        }

        return found

    }
}