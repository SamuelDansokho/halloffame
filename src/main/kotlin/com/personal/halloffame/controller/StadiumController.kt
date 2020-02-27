package com.personal.halloffame.controller

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Stadium
import com.personal.halloffame.service.PersonService
import com.personal.halloffame.service.StadiumService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*

@RestController
@RequestMapping("/stadium")
class StadiumController(var stadiumService: StadiumService){

        @GetMapping("/get/{id}")
        fun getStadium(@PathVariable("id") id:Int ): Stadium {
                return stadiumService.getStadium(id)
        }

}
