package com.personal.halloffame.repository


import com.personal.halloffame.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Person, Int> {

}
