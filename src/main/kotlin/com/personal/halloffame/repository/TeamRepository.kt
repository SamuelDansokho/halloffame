package com.personal.halloffame.repository


import com.personal.halloffame.model.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository: JpaRepository<Team, Int> {
}


