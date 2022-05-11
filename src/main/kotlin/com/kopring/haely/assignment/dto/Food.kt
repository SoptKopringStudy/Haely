package com.kopring.haely.assignment.dto

data class Food(
    val name: String,
    val price: Int
){
    override fun toString() = "$name ${price}원"
}