package com.personal.halloffame.repository


import com.personal.halloffame.model.Trophy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrophyRepository: JpaRepository<Trophy, Long> {
  fun findById(id: Int): Trophy;
 }