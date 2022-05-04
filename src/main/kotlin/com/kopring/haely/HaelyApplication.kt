package com.kopring.haely

import com.kopring.haely.assignment.dto.Food
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HaelyApplication

fun main() {
    parenthesisStr()
    receiptPrint()
}

// 2. Parenthesis String
private fun parenthesisStr() {
    var answer = ""
    val n = readln().toInt()
    for (i in 1..n) {
        val ps = readln()
        val psKStack = KStack<Char>()
        var isVPS = true
        ps.forEach {
            when (it) {
                '(' -> psKStack.push(it)
                else -> {
                    if (psKStack.size() == 0) {
                        isVPS = false
                    } else {
                        psKStack.pop()
                    }
                }
            }
        }
        answer = when {
            psKStack.size() == 0 && isVPS -> "YES"
            else -> "NO"
        }
        println(answer)
    }
}

// 3. Receipt
private fun receiptPrint(){
    val FoodList = listOf<Food>(
        Food("돼지목살", 6000),
        Food("제로콜라", 2000),
        Food("민트초코오레오", 1500),
        Food("진라면순한맛", 1000)
    )

    FoodList.forEach {
        println(it)
    }
    println("----------------")
    val priceSum = FoodList.sumOf { it.price }
    println("총합 ${priceSum}")
}

// 1. Stack
private class KStack<T> {
    val kList = mutableListOf<T>()
    fun push(elem: T) = kList.add(elem)
    fun pop(): T = kList.removeLast()
    fun size(): Int = kList.size
    fun find(elem: T): Boolean = kList.contains(elem)
}