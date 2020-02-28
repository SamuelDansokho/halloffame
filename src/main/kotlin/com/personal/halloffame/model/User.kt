package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name="user")

data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int = 0,
        @Column(unique = true) val username: String,
        val password: String? = null,
        @Column(unique = true) val email: String,
        @Column(unique = true) val displayname: String? = null,
        val isAdmin: Boolean? = null
)
