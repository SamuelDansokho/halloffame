package com.personal.halloffame.service

import com.personal.halloffame.model.User
import com.personal.halloffame.repository.UserRepository
import javassist.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {

    @Autowired
    private lateinit var userRepository : UserRepository

    @Transactional(readOnly = true)
    fun getUser( id: Int) : User {
        return userRepository.findById(id).orElse(null)?:throw NotFoundException("User $id not found")
    }

    @Transactional(readOnly = true)
    fun getAllUser() : List<User> {
        return userRepository.findAll()
    }

    /**
     * Duplicate users in database will be dealt with
     */
    @Transactional
    fun createUser(username:String,displayname: String?, password: String, email: String, isAdmin: Boolean): CreationEnum{
        val check = checkEmailInDB(email)
        if(!check){
            val user = User(null,username,password,email,displayname, isAdmin)
            userRepository.save(user)
            return CreationEnum.OK
        } else return CreationEnum.ALREADY_IN_BDD

    }

    /**
     * Checks if user exists in DB based on email
     */
    fun checkEmailInDB(email: String): Boolean{
        val users = getAllUser()
        val potentialEmails =users.filter { it -> it.email==email }
        if(potentialEmails.isNotEmpty()) {
            LoggerFactory.getLogger(this::class.java).error("Email already in DB")
            return true
        } else return false
    }

    enum class CreationEnum{
        OK,ALREADY_IN_BDD,KO
    }

}