package com.personal.halloffame.repository


import com.personal.halloffame.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, Int>{

 fun save(user: User)

 fun findByUsername(name : String): UserDetails
}