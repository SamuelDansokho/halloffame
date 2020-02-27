package com.personal.halloffame.controller

import com.personal.halloffame.model.User
import com.personal.halloffame.repository.UserRepository
import com.personal.halloffame.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(var userService: UserService){

    @GetMapping("/list")
    fun getUserList(): List<User>{
        return userService.getAllUser()
    }

    @PostMapping("/create")
    fun createUser(){
        val famalam = User(username = "wagwan",password = "famalam",email = "swag1",isAdmin = true)
        userService.createUser(famalam)
    }

    @GetMapping("/get/{id}")
    fun getUser(@PathVariable("id") id: Int): User{
        return userService.getUser(id)
    }

}