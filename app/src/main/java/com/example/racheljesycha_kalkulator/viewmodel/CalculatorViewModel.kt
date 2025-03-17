package com.example.racheljesycha_kalkulator.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class CalculatorViewModel : ViewModel() {

    var input = mutableStateOf("0")

    fun onButtonClick(value: String) {
        when (value) {
            "C" -> input.value = "0"
            "⌫" -> input.value = if (input.value.length > 1) input.value.dropLast(1) else "0"
            "=" -> calculateResult()
            else -> {
                if (input.value == "0" && value != ".") {
                    input.value = value
                } else {
                    input.value += value
                }
            }
        }
    }

    private fun calculateResult() {
        try {
            val result = evaluateExpression(input.value)
            input.value = if (result % 1 == 0.0) {
                result.toInt().toString() // Hasil integer jika tidak ada desimal
            } else {
                result.toString() // Hasil float jika ada desimal
            }
        } catch (e: Exception) {
            input.value = "Error"
        }
    }

    private fun evaluateExpression(expression: String): Double {
        val replacedExpression = expression
            .replace("×", "*")
            .replace("÷", "/")
            .replace("%", "/100")

        return object : Any() {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < replacedExpression.length) replacedExpression[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < replacedExpression.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    when {
                        eat('+'.code) -> x += parseTerm()
                        eat('-'.code) -> x -= parseTerm()
                        else -> return x
                    }
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    when {
                        eat('*'.code) -> x *= parseFactor()
                        eat('/'.code) -> x /= parseFactor()
                        else -> return x
                    }
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()

                var x: Double
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if (ch in '0'.code..'9'.code || ch == '.'.code) {
                    while (ch in '0'.code..'9'.code || ch == '.'.code) nextChar()
                    x = replacedExpression.substring(startPos, pos).toDouble()
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }

                return x
            }
        }.parse()
    }
}
