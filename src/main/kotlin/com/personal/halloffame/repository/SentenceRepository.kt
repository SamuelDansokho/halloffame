package com.personal.halloffame.repository


import com.personal.halloffame.model.Sentence
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

@Repository
interface SentenceRepository: JpaRepository<Sentence, Int> {
}


