package com.personal.halloffame.repository


import com.personal.halloffame.model.*
import org.springframework.data.jpa.repository.JpaRepository


interface PersonRepository: JpaRepository<Person, Long> {
 fun findById(id: Int): Person;
}
