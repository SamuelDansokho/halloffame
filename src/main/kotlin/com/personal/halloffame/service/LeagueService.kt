package com.personal.halloffame.service

import com.personal.halloffame.model.League
import com.personal.halloffame.model.Person
import com.personal.halloffame.repository.LeagueRepository
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LeagueService {

    @Autowired
    private lateinit var leagueRepository : LeagueRepository

    @Transactional(readOnly = true)
    fun getLeague( id: Int) : League {
        return leagueRepository.findById(id).orElse(null)?:throw NotFoundException("League $id not found")
    }

}