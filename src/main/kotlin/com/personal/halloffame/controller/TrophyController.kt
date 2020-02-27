package com.personal.halloffame.controller

import com.personal.halloffame.model.Trophy
import com.personal.halloffame.model.User
import com.personal.halloffame.repository.UserRepository
import com.personal.halloffame.service.TrophyService
import com.personal.halloffame.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/trophy")
class TrophyController(var trophyService: TrophyService){

    @GetMapping("/get/{id}")
    fun getTrophy(@PathVariable("id") id: Int): Trophy {
        return trophyService.getTrophy(id)
    }

}