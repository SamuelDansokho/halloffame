package com.personal.halloffame.controller

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Sentence
import com.personal.halloffame.service.PersonService
import com.personal.halloffame.service.SentenceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.*

@RestController
@RequestMapping("/sentence")
class SentenceController(var sentenceService: SentenceService){

        @GetMapping("/get/{id}")
        fun getSentence(@PathVariable("id") id:Int ): Sentence {
                return sentenceService.getSentence(id)
        }

}
