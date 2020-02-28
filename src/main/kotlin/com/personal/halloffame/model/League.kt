package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name= "league")
data class League(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        @Column(unique = true) val name: String,
        @OneToOne val trophy: Trophy,
        val country: String
)