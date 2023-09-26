package com.example

fun main(){
    print("Please input word:")
    val word = readLine()
    val regex = Regex("\\d") // This regex matches any digit

    val digits = regex.findAll(word!!)
        .map { it.value }
        .joinToString("")

    println(digits)
}