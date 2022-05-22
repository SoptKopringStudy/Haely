package com.kopring.haely.presentation.model

data class UserDto(
    val user_idx: Long,
    val name: String,
    val part: String
) {
    fun introduce() = "이름 : $name 파트 : $part"
    fun isAlreadyName(other: String) = name == other
    fun isAlreadyUser(otherName: String, otherPart: String) = name == otherName && part == otherPart
    fun isEqualId(id: Long) = id == user_idx
}
