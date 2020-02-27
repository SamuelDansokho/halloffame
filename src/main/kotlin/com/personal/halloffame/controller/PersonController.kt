package com.personal.halloffame.controller

import com.personal.halloffame.model.Person
import com.personal.halloffame.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*

@RestController
@RequestMapping("/person")
class PersonController(var personService: PersonService){

        @GetMapping("/get/{id}")
        fun getPerson(@PathVariable("id") id:Int ): Person {
                return personService.getPerson(id)
        }

}
