package com.personal.halloffame.service

import com.personal.halloffame.model.Person
import com.personal.halloffame.repository.PersonRepository
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository : PersonRepository

    @Transactional(readOnly = true)
    fun getPerson( id: Int) : Person {
        return personRepository.findById(id).orElse(null)?:throw NotFoundException("Person $id not found")
    }

}