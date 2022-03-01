package com.r3d1r4ph.calculatoronjetpackcompose.model

import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButtons
import com.r3d1r4ph.calculatoronjetpackcompose.model.Constants.*

class CalculatorProcessing {
    private companion object {
        const val DISPLAY_NUMBERS_COUNT = 10
        const val DISPLAY_ADD_NUMBER = DISPLAY_NUMBERS_COUNT - 2
        const val DISPLAY_CONCLUSION = DISPLAY_NUMBERS_COUNT - 3
    }

    private var first = EMPTY.value
    private var last = EMPTY.value
    private var operation: Operations? = null
    private var afterOp = EMPTY.value
    private var newCircle = true
    // - Эта переменная принимает значение false только после операций
    // - "%" и "=". Это значит, что мы можем взять его как первое
    // - Слагаемое/множитель (вместо first), то есть после него сразу
    // - Можно применить операции (+,-,*,/), а потом задать второе число.
    // - Если этой возможностью не воспользоваться(Нажать AC или начать
    // - Вводить первое число, то переменная снова принимает значение true)

    private fun pointToComma(number: String): String {
        return if (number.contains(DOT.value)) {
            number.replace(DOT.value, COMMA.value)
        } else number
    }

    private fun commaToPoint(number: String): String {
        return if (number.contains(COMMA.value)) {
            number.replace(COMMA.value, DOT.value)
        } else number
    }

    private fun firstCheck(): String {
        return if (first.length > DISPLAY_NUMBERS_COUNT) {
            "${DOT.value}${DOT.value}${
                first.substring(
                    first.length - DISPLAY_ADD_NUMBER,
                    first.length
                )
            }"
        } else {
            first
        }
    }

    private fun lastCheck(): String {
        return if (afterOp.length + last.length > DISPLAY_NUMBERS_COUNT) {
            "${DOT.value}${DOT.value}${
                (afterOp + last).substring(
                    (afterOp + last).length - DISPLAY_ADD_NUMBER,
                    (afterOp + last).length
                )
            }"
        } else {
            "$afterOp$last"
        }
    }

    private fun addNumber(num: String): String {
        return if (operation == null) {
            if (!newCircle) {
                newCircle = true
                first = EMPTY.value
            }

            first = addNumberCheck(first, num)
            firstCheck()
        } else {
            last = addNumberCheck(last, num)
            lastCheck()
        }
    }

    private fun addNumberCheck(oldNumber: String, newSymbol: String) =
        if (oldNumber == ZERO.value) {
            newSymbol
        } else if (!(oldNumber == MINUS.value && newSymbol == ZERO.value)) {
            oldNumber + newSymbol
        } else {
            oldNumber
        }

    fun clickOnDigit(num: String): String {
        return addNumber(num)
    }

    private fun operationProcessing(oper: NumPadButtons): String? {
        if (first.isNotEmpty() && first != MINUS.value && last.isEmpty()) {
            operation = when (oper) {
                NumPadButtons.MULTIPLY -> Operations.MULTIPLICATION
                NumPadButtons.DIVIDE -> Operations.DIVIDE
                NumPadButtons.MINUS -> Operations.MINUS
                else -> Operations.PLUS
            }

            afterOp = first
            first += operation?.def

            val padText = firstCheck()
            first = afterOp
            afterOp = first + operation?.def
            return padText
        }
        return null
    }

    fun clickOnOperation(oper: NumPadButtons): String? {
        return operationProcessing(oper)
    }

    fun processingAC(): String {
        first = EMPTY.value
        last = EMPTY.value
        afterOp = EMPTY.value
        operation = null
        newCircle = true
        return ZERO.value
    }

    private fun commaInput(num: String): String {
        var number = num
        if (number.isNotEmpty() && !(number.length == 1 && number == MINUS.value)) {
            if (!number.contains(COMMA.value)) {
                number += COMMA.value
            }
        } else {
            number += "${ZERO.value}${COMMA.value}"
        }
        return number
    }

    fun processingComma(): String? {
        if (operation == null) {
            if (newCircle) {
                first = commaInput(first)
                return firstCheck()
            }
        } else {
            last = commaInput(last)
            return lastCheck()
        }
        return null
    }

    private fun processPlusMinus(num: String, check: Boolean): String {
        var number = num
        if (number.isNotEmpty()) {
            if (number.contains(MINUS.value)) {
                number = number.drop(1)
                if (check && number.isEmpty()) {
                    number = ZERO.value
                }
            } else {
                if (number != ZERO.value) {
                    number = "${MINUS.value}$number"
                } else if (check) {
                    number = MINUS.value
                }
            }
        } else {
            number = MINUS.value
        }
        return number
    }

    fun processingPlusMinus(): String {
        return if (operation == null) {
            first = processPlusMinus(first, true)
            firstCheck()

        } else {
            last = processPlusMinus(last, false)
            lastCheck()
        }
    }

    private fun processingConclusion(concl: String, l: Double): String {
        val padText: String
        var conclusion = concl
        if (conclusion[conclusion.length - 1].toString() == ZERO.value
            && conclusion[conclusion.length - 2].toString() == DOT.value
        ) {
            conclusion = conclusion.substring(0, conclusion.length - 2)
        }

        padText = padTextFromConclusion(conclusion)

        if (l != 0.0) {
            first = pointToComma(conclusion)
            newCircle = false
        } else {
            first = EMPTY.value
            newCircle = true
        }
        last = EMPTY.value
        afterOp = EMPTY.value
        operation = null
        return padText
    }

    private fun padTextFromConclusion(conclusion: String) =
        if (conclusion != "${MINUS.value}${ZERO.value}") {
            if (conclusion.length > DISPLAY_NUMBERS_COUNT) {
                if (conclusion.contains(E.value)) {

                    val indOfE = conclusion.indexOf(E.value)
                    val partE = conclusion.substring(indOfE)
                    val partELength = partE.length

                    val firstPartOfPad = conclusion.substring(0, DISPLAY_CONCLUSION - partELength)
                    "${EQUALITY.value}${pointToComma(firstPartOfPad)}${DOT.value}${DOT.value}$partE"
                } else {
                    "${EQUALITY.value}${
                        pointToComma(
                            conclusion.substring(
                                0,
                                DISPLAY_CONCLUSION
                            )
                        )
                    }${DOT.value}${DOT.value}"
                }
            } else {
                "${EQUALITY.value}${pointToComma(conclusion)}"
            }
        } else {
            "${EQUALITY.value}${ZERO.value}"
        }

    private fun preCounting(): Int {
        var toMultiplicate = 1
        if (operation == Operations.MULTIPLICATION || operation == Operations.DIVIDE) {
            if (first.contains(MINUS.value)) {
                toMultiplicate *= -1
                first = first.drop(1)
            }
            if (last.contains(MINUS.value)) {
                toMultiplicate *= -1
                last = last.drop(1)
            }
        } else {
            if (last.contains(MINUS.value)) {
                last = last.drop(1)
                when (operation) {
                    Operations.PLUS -> operation = Operations.MINUS
                    Operations.MINUS -> operation = Operations.PLUS
                    else -> {
                    }
                }
            }
        }
        return toMultiplicate
    }

    fun processingPercent(): String? {
        if (last.isNotEmpty() && last != MINUS.value) {

            val toMultiplicate = preCounting()

            val f = commaToPoint(first).toDouble()
            var l = commaToPoint(last).toDouble()

            if (operation == Operations.MULTIPLICATION || operation == Operations.DIVIDE) {
                l /= 100
            } else {
                l = l / 100 * f
            }

            val conclusion = getConclusionByOperation(operation, f, l, toMultiplicate)

            return processingConclusion(conclusion, l)
        }
        return null
    }

    private fun getConclusionByOperation(
        operation: Operations?,
        f: Double,
        l: Double,
        toMultiplicate: Int
    ) =
        when (operation) {
            Operations.PLUS -> {
                ((f + l) * toMultiplicate).toString()
            }
            Operations.MINUS -> {
                ((f - l) * toMultiplicate).toString()
            }
            Operations.MULTIPLICATION -> {
                ((f * l) * toMultiplicate).toString()
            }
            Operations.DIVIDE -> {
                if (l == 0.0) {
                    DIVIDE_EXCEPTION.value
                } else {
                    ((f / l) * toMultiplicate).toString()
                }
            }
            else -> EMPTY.value
        }

    fun processingEquality(): String? {
        if (last.isNotEmpty() && last != MINUS.value) {

            first = commaToPoint(first)
            last = commaToPoint(last)

            val f: Double = first.toDouble()
            val l: Double = last.toDouble()
            var conclusion = EMPTY.value

            when (operation) {
                Operations.PLUS -> conclusion = (f + l).toString()
                Operations.MINUS -> conclusion = (f - l).toString()
                Operations.MULTIPLICATION -> conclusion = (f * l).toString()
                Operations.DIVIDE -> {
                    conclusion = if (l == 0.0) {
                        DIVIDE_EXCEPTION.value
                    } else {
                        (f / l).toString()
                    }
                }
                else -> {}
            }

            return processingConclusion(conclusion, l)
        }
        return null
    }
}