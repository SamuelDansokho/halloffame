package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name="trophy",uniqueConstraints = [UniqueConstraint(columnNames=["name"])])
data class Trophy(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        val name: String,
        @ElementCollection val successHistory: List<Pair<Team,Team>>
)