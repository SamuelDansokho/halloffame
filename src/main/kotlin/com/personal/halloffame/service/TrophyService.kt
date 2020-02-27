package com.personal.halloffame.service

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Trophy
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.TrophyRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TrophyService {

    @Autowired
    private lateinit var trophyRepository: TrophyRepository

    @Transactional(readOnly = true)
    fun getTrophy( id: Int) : Trophy {
        return trophyRepository.findById(id).orElse(null)?:throw NotFoundException("Trophy $id not found")
    }

}