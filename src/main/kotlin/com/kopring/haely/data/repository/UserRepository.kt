package com.kopring.haely.repository

import com.kopring.haely.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, Long> {
    fun findUserEntityByName(name: String): UserEntity?
}