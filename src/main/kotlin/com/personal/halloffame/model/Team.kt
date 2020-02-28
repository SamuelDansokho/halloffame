package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name="team")
data class Team(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int,
        @Column(unique = true) val name: String,
        val country: String,
        @OneToMany val trophyHistory: List<Trophy>,
        @OneToMany val managerHistory: List<Person>,
        @OneToMany val playerHistory: List<Person>,
        @OneToMany val staffMembers: List<Person>
)