package br.com.edilsonvilarinho.calculadoraimc

import java.io.Serializable

class Resultado(val peso: Double, val altura: Double, val imc: Double, val diagnostico: String) :
    Serializable