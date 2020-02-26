package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private val id: Int,
        private val firstname: String,
        private val lastname: String,
        private val age: Int,
        @ElementCollection private val nationality: List<String>?,
        @OneToMany private val clubHistory: List<Team>?
)
