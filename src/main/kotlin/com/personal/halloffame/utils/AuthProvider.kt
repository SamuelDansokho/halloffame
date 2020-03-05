package com.personal.halloffame.utils

import com.personal.halloffame.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component

@Component
class AuthProvider : DaoAuthenticationProvider() {
    @Autowired
    lateinit var userDetailsService : UserService;

    override fun authenticate(authInstance: Authentication): Authentication{
        var auth : UsernamePasswordAuthenticationToken  =  authInstance as UsernamePasswordAuthenticationToken

        var name : String = auth.name
        var password : String = auth.credentials.toString()

        System.out.println("------------------------------------------ SAMUEL DEBUG -------------------------------------------------------")
        System.out.println(name)

        var user: UserDetails = userDetailsService.loadUserByUsername(name)

        System.out.println("------------------------------------------ SAMUEL DEBUG -------------------------------------------------------")
        System.out.println(user)

        return UsernamePasswordAuthenticationToken(user,null,user.authorities)
    }
}