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
    val n = readln().toInt()
    repeat(n) {
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
        var answer = when {
            psKStack.size() == 0 && isVPS -> "YES"
            else -> "NO"
        }
        println(answer)
    }
}

// 3. Receipt
private fun receiptPrint(){
    val foodList = listOf<Food>(
        Food("돼지목살", 6000),
        Food("제로콜라", 2000),
        Food("민트초코오레오", 1500),
        Food("진라면순한맛", 1000)
    )

    foodList.forEach {
        println(it)
    }
    println("----------------")
    println("총합 ${foodList.sumOf { it.price }}")
}

// 1. Stack
private class KStack<T> {
    val list = mutableListOf<T>()
    fun push(elem: T) = list.add(elem)
    fun pop(): T = list.removeLast()
    fun size(): Int = list.size
    fun find(element: T): Boolean = list.contains(element)
}