package com.personal.halloffame.service

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Sentence
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.SentenceRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SentenceService {

    @Autowired
    private lateinit var sentenceRepository: SentenceRepository

    @Transactional(readOnly = true)
    fun getSentence( id: Int) : Sentence {
        return sentenceRepository.findById(id).orElse(null)?:throw NotFoundException("Sentence $id not found")
    }

}