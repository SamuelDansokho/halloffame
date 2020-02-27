package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name = "stadium",uniqueConstraints = [UniqueConstraint(columnNames=["name"])])
data class Stadium(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        val name: String,
        @OneToMany val homeTeam: List<Team>,
        val country: String,
        val city: String,
        val size: Int?

)