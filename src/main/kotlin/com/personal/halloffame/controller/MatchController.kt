package com.personal.halloffame.controller

import com.personal.halloffame.model.Match
import com.personal.halloffame.model.Person
import com.personal.halloffame.service.MatchService
import com.personal.halloffame.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*

@RestController
@RequestMapping("/match")
class MatchController(var matchService: MatchService){

        @GetMapping("/get/{id}")
        fun getMatch(@PathVariable("id") id:Int ): Match {
                return matchService.getMatch(id)
        }

}
