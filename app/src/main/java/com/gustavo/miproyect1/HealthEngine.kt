package com.gustavo.miproyect1

    fun clasificarIMC(peso: Double, altura: Double): String {
        // Cálculo matemático del IMC: Peso / Altura al cuadrado
        val imc = peso / (altura * altura)

        // Estructura when para retornar la clasificación según los rangos
        return when {
            imc < 18.5 -> "Bajo peso"
            imc >= 18.5 && imc <= 24.9 -> "Peso normal"
            imc >= 25.0 && imc <= 29.9 -> "Sobrepeso"
            imc >= 30.0 -> "Obesidad"
            else -> "Rango no definido"
        }
    }
