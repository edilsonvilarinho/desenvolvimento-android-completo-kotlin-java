package org.example

import kotlin.math.sqrt

abstract class Area {
    abstract fun calular(): Number
}


class Quadrado(var lado: Double) : Area() {
    override fun calular(): Number {
        return sqrt(lado)
    }
}

class Triangulo(var base: Double, var altura: Double) : Area() {
    override fun calular(): Number {
        return base * altura / 2
    }
}


fun main() {
    println(Quadrado(1.0).calular())
    println(Triangulo(1.5 , 2.0).calular())
}