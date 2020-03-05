package com.personal.halloffame.controller

import com.personal.halloffame.utils.AuthProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecurityController {

    @PostMapping("/login")
    fun userLogin(username: String, password: String): String{
        return "success"
    }
}