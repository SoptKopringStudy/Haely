package com.kopring.haely.service

import com.kopring.haely.model.User
import com.kopring.haely.data.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
) : UserService {
    private val userList = mutableListOf<User>()

    override fun findAllUsers(): String{
        val users = userRepository.findAll()
        return if (users.isEmpty()) "유저가 없습니다!" else users.joinToString{ it.name }
    }

//    override fun findUserByName(name: String) = userRepository.findUserEntityByName(name)?.toUser()?: User(0, "", "")
}