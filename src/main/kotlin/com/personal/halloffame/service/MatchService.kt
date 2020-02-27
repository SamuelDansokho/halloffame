package com.personal.halloffame.service

import com.personal.halloffame.model.Match
import com.personal.halloffame.model.Person
import com.personal.halloffame.repository.MatchRepository
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MatchService {

    @Autowired
    private lateinit var matchRepository: MatchRepository

    @Transactional(readOnly = true)
    fun getMatch( id: Int) : Match {
        return matchRepository.findById(id).orElse(null)?:throw NotFoundException("Match $id not found")
    }

}