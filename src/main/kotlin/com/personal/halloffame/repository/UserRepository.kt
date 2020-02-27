package com.personal.halloffame.repository


import com.personal.halloffame.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
interface UserRepository: JpaRepository<User, Int>{

 fun save(user: User)
}