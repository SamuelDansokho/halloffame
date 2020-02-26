package com.personal.halloffame.repository


import com.personal.halloffame.model.League
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeagueRepository: JpaRepository<League, Long> {
 fun findById(id: Int): League;
 }