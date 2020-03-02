package com.personal.halloffame.controller

import com.personal.halloffame.model.User
import com.personal.halloffame.service.UserService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:4200"], maxAge = 3600)
@RestController
@RequestMapping("/user")
class UserController(var userService: UserService){

    @GetMapping("/list")
    fun getUserList(): List<User>{
        return userService.getAllUser()
    }

    @PostMapping("/create")
    fun createUser(@RequestBody(required = true) user: User): UserService.CreationEnum {
        return userService.createUser(user.username,user.displayname,user.password,user.email,user.isAdmin)
    }

    @GetMapping("/get/{id}")
    fun getUser(@PathVariable("id") id: Int): User{
        return userService.getUser(id)
    }

}