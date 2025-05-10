package org.example

const val SIM = "SIM"
const val NAO = "NAO"
const val QUALQUER = "QUALQUER"

fun main() {
    val opcao: String = QUALQUER
    when (opcao) {
        SIM -> println(SIM)
        NAO -> println(NAO)
        QUALQUER -> println(QUALQUER)
        else -> println(" oxi ?  ")
    }
}