package org.example

fun main() {
    val nomes = arrayOf("joão", "pedro")
    for (n in nomes) {
        println(n)
    }

    for (n in 1..1000) {
        println(n)
    }

    val postagens = arrayOf("DEU RUIM ", " OPAAAAA ", "VIIIIIIIIIIII")
    for ((index, postagem) in postagens.withIndex()) {
        println(" $index - $postagem ")
    }
}