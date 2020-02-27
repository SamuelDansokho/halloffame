package com.personal.halloffame.controller

import com.personal.halloffame.model.League
import com.personal.halloffame.model.Person
import com.personal.halloffame.service.LeagueService
import com.personal.halloffame.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*

@RestController
@RequestMapping("/league")
class LeagueController(var leagueService: LeagueService){

        @GetMapping("/get/{id}")
        fun getLeague(@PathVariable("id") id:Int ): League {
                return leagueService.getLeague(id)
        }

}
