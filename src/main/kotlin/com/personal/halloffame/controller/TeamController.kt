package com.personal.halloffame.controller

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Team
import com.personal.halloffame.service.PersonService
import com.personal.halloffame.service.TeamService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*

@RestController
@RequestMapping("/team")
class TeamController(var teamService: TeamService){

        @GetMapping("/get/{id}")
        fun getTeam(@PathVariable("id") id:Int ): Team {
                return teamService.getTeam(id)
        }

}
