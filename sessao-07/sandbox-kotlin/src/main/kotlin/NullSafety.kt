package org.example

class Pessoa(var nome: String, var idade: Int)

fun main() {
    val pessoa: Pessoa? = null
    try {
        println(message = pessoa!!.nome!!.get(0))
    } catch (e: Exception) {
        println("deu ruim =( ")
    }
    try {
        println(message = pessoa?.nome?.get(0) ?: "defult")
        println("NUNCA MAIS Exception ")
    } catch (e: Exception) {
        println("deu ruim =( ")
    }
}