package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name= "league",uniqueConstraints = [UniqueConstraint(columnNames=["name"])])
data class League(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        val name: String,
        @OneToOne val trophy: Trophy,
        val country: String
)