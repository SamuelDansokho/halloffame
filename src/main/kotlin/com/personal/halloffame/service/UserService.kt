package com.personal.halloffame.service

import com.personal.halloffame.model.User
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {

    @Autowired
    private lateinit var userRepository : UserRepository

    @Transactional(readOnly = true)
    fun getUser( id: Long) : User {
        return userRepository.findById(id).orElse(null)?: throw NotFoundException("Book $id not found")
    }

    @Transactional(readOnly = true)
    fun getAllUser() : List<User> {
        return userRepository.findAll()?:throw NotFoundException("No user found")
    }

    @Transactional
    fun createUser(user : User){
        userRepository.save(user)
    }
}