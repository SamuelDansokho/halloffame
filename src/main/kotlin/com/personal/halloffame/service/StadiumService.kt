package com.personal.halloffame.service

import com.personal.halloffame.model.Person
import com.personal.halloffame.model.Stadium
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.StadiumRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StadiumService {

    @Autowired
    private lateinit var stadiumRepository: StadiumRepository

    @Transactional(readOnly = true)
    fun getStadium( id: Int) : Stadium {
        return stadiumRepository.findById(id).orElse(null)?:throw NotFoundException("Stadium $id not found")
    }

}