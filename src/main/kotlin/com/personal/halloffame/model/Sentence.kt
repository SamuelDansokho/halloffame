package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name = "sentence")
data class Sentence(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private val id: Int,
        @ElementCollection private val parts: List<String>
)