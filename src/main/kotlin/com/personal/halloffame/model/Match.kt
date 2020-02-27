package com.personal.halloffame.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name="matches")
data class Match(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        @OneToOne val homeTeam: Team,
        @OneToOne val awayTeam: Team,
        val homeTeamScore: Int,
        val awayTeamScore: Int,
        val date: Date
)