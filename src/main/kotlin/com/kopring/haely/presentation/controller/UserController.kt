package com.kopring.haely.controller

import com.kopring.haely.domain.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
){
    @GetMapping("")
    fun getUsers() = userService.findAllUsers()
}