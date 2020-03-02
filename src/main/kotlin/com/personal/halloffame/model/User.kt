package com.personal.halloffame.model

import javax.persistence.*

@Entity
@Table(name="user")

data class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int?,
        @Column(unique = true) val username: String,
        val password: String,
        @Column(unique = true) val email: String,
        @Column(unique = true) val displayname: String? = null,
        val isAdmin: Boolean = false
)
