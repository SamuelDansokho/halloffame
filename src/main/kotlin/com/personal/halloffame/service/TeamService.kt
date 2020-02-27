package com.personal.halloffame.service

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Team
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.TeamRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamService {

    @Autowired
    private lateinit var teamRepository: TeamRepository

    @Transactional(readOnly = true)
    fun getTeam( id: Int) : Team {
        return teamRepository.findById(id).orElse(null)?:throw NotFoundException("Team $id not found")
    }

}