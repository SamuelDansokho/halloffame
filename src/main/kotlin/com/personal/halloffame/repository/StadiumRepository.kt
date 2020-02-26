package com.personal.halloffame.repository


import com.personal.halloffame.model.Stadium
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StadiumRepository: JpaRepository<Stadium, Long> {
 fun findById(id: Int): Stadium;
 }