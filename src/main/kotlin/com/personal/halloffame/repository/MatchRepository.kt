package com.personal.halloffame.repository


import com.personal.halloffame.model.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository: JpaRepository<Match, Long> {
 fun findById(id: Int): Match;
 }