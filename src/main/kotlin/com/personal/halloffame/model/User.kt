package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name="user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Int = 0,
        val username: String? = null,
        val password: String? = null,
        val email: String? = null,
        val displayname: String? = null,
        val isAdmin: Boolean? = null
)
