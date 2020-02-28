package com.personal.halloffame.controller

import com.personal.halloffame.model.User
import com.personal.halloffame.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user")
class UserController(var userService: UserService){

    @GetMapping("/list")
    fun getUserList(): List<User>{
        return userService.getAllUser()
    }

    @PostMapping("/create")
    fun createUser(): UserService.CreationEnum {
        userService.createUser()
    }

    @GetMapping("/get/{id}")
    fun getUser(@PathVariable("id") id: Int): User{
        return userService.getUser(id)
    }

}