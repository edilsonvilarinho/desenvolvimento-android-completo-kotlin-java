package org.example

import kotlin.math.sqrt

interface Calcular {
    fun calcular(): Number
}

abstract class Area


class Quadrado(var lado: Double) : Area(), Calcular {
    override fun calcular(): Number {
        return sqrt(lado)
    }
}

class Triangulo(var base: Double, var altura: Double) : Area(), Calcular {
    override fun calcular(): Number {
        return base * altura / 2
    }
}


fun main() {
    println(Quadrado(1.0).calcular())
    println(Triangulo(1.5, 2.0).calcular())
}