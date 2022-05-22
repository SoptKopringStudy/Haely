package com.kopring.haely.data.model

import com.kopring.haely.presentation.model.User
import javax.persistence.*

@Entity
@Table(name = "user")
class UserModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val user_idx: Long,
    @Column(length = 45, nullable = false)
    val name: String,
    @Column(length = 45, nullable = false)
    private val part: String
) {
    constructor(): this(0, "", "")

    fun toUser() = User(user_idx, name, part)

}