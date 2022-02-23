package com.r3d1r4ph.calculatoronjetpackcompose.model

class CalculatorProcessing {
    private companion object {
        const val DISPLAY_NUMBERS_COUNT = 10
        const val DISPLAY_ADD_NUMBER = DISPLAY_NUMBERS_COUNT - 2
        const val DISPLAY_CONCLUSION = DISPLAY_NUMBERS_COUNT - 3
        const val DOT = '.'
        const val COMMA = ','
        const val E = 'E'
        const val MINUS = '-'
        const val ZERO = '0'
        const val DIVIDE_EXCEPTION = "/0"
        const val MULTIPLICATION = "X"
        const val DIVIDE = "÷"
        const val EQUALITY = '='
        const val EMPTY = ""
    }

    private var first = EMPTY
    private var last = EMPTY
    private var operation: Operations? = null
    private var afterOp = EMPTY
    private var newCircle = true
    // - Эта переменная принимает значение false только после операций
    // - "%" и "=". Это значит, что мы можем взять его как первое
    // - Слагаемое/множитель (вместо first), то есть после него сразу
    // - Можно применить операции (+,-,*,/), а потом задать второе число.
    // - Если этой возможностью не воспользоваться(Нажать AC или начать
    // - Вводить первое число, то переменная снова принимает значение true)

    private fun pointToComma(number: String): String {
        return if (number.contains(DOT)) {
            number.replace(DOT, COMMA)
        } else number
    }

    private fun commaToPoint(number: String): String {
        return if (number.contains(COMMA)) {
            number.replace(COMMA, DOT)
        } else number
    }

    private fun firstCheck(): String {
        return if (first.length > DISPLAY_NUMBERS_COUNT) {
            "$DOT$DOT${first.substring(first.length - DISPLAY_ADD_NUMBER, first.length)}"
        } else {
            first
        }
    }

    private fun lastCheck(): String {
        return if (afterOp.length + last.length > DISPLAY_NUMBERS_COUNT) {
            "$DOT$DOT${
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
                first = EMPTY
            }

            first = addNumberCheck(first, num)
            firstCheck()
        } else {
            last = addNumberCheck(last, num)
            lastCheck()
        }
    }

    private fun addNumberCheck(oldNumber: String, newSymbol: String) =
        if (oldNumber == ZERO.toString()) {
            newSymbol
        } else if (!(oldNumber == MINUS.toString() && newSymbol == ZERO.toString())) {
            oldNumber + newSymbol
        } else {
            oldNumber
        }

    fun clickOnDigit(num: String): String {
        return addNumber(num)
    }

    private fun operationProcessing(oper: String): String? {
        if (first.isNotEmpty() && first != MINUS.toString() && last.isEmpty()) {
            operation = when (oper) {
                MULTIPLICATION -> Operations.MULTIPLICATION
                DIVIDE -> Operations.DIVIDE
                MINUS.toString() -> Operations.MINUS
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

    fun clickOnOperation(oper: String): String? {
        return operationProcessing(oper)
    }

    fun processingAC(): String {
        first = EMPTY
        last = EMPTY
        afterOp = EMPTY
        operation = null
        newCircle = true
        return ZERO.toString()
    }

    private fun commaInput(num: String): String {
        var number = num
        if (number.isNotEmpty() && !(number.length == 1 && number == MINUS.toString())) {
            if (!number.contains(COMMA)) {
                number += COMMA
            }
        } else {
            number += "$ZERO$COMMA"
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
            if (number.contains(MINUS)) {
                number = number.drop(1)
                if (check && number.isEmpty()) {
                    number = ZERO.toString()
                }
            } else {
                if (number != ZERO.toString()) {
                    number = "$MINUS$number"
                } else if (check) {
                    number = MINUS.toString()
                }
            }
        } else {
            number = MINUS.toString()
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
        if (conclusion[conclusion.length - 1] == ZERO
            && conclusion[conclusion.length - 2] == DOT
        ) {
            conclusion = conclusion.substring(0, conclusion.length - 2)
        }

        padText = padTextFromConclusion(conclusion)

        if (l != 0.0) {
            first = pointToComma(conclusion)
            newCircle = false
        } else {
            first = EMPTY
            newCircle = true
        }
        last = EMPTY
        afterOp = EMPTY
        operation = null
        return padText
    }

    private fun padTextFromConclusion(conclusion: String) =
        if (conclusion != "$MINUS$ZERO") {
            if (conclusion.length > DISPLAY_NUMBERS_COUNT) {
                if (conclusion.contains(E)) {

                    val indOfE = conclusion.indexOf(E)
                    val partE = conclusion.substring(indOfE)
                    val partELength = partE.length

                    val firstPartOfPad = conclusion.substring(0, DISPLAY_CONCLUSION - partELength)
                    "$EQUALITY${pointToComma(firstPartOfPad)}$DOT$DOT$partE"
                } else {
                    "$EQUALITY${pointToComma(conclusion.substring(0, DISPLAY_CONCLUSION))}$DOT$DOT"
                }
            } else {
                "$EQUALITY${pointToComma(conclusion)}"
            }
        } else {
            "$EQUALITY$ZERO"
        }

    private fun preCounting(): Int {
        var toMultiplicate = 1
        if (operation == Operations.MULTIPLICATION || operation == Operations.DIVIDE) {
            if (first.contains(MINUS)) {
                toMultiplicate *= -1
                first = first.drop(1)
            }
            if (last.contains(MINUS)) {
                toMultiplicate *= -1
                last = last.drop(1)
            }
        } else {
            if (last.contains(MINUS)) {
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
        if (last.isNotEmpty() && last != MINUS.toString()) {

            val toMultiplicate = preCounting()

            val f = commaToPoint(first).toDouble()
            var l = commaToPoint(last).toDouble()

            if (operation == Operations.MULTIPLICATION || operation == Operations.DIVIDE) {
                l /= 100
            } else {
                l = l / 100 * f
            }

            var conclusion = EMPTY
            when (operation) {
                Operations.PLUS -> {
                    conclusion = ((f + l) * toMultiplicate).toString()
                }
                Operations.MINUS -> {
                    conclusion = ((f - l) * toMultiplicate).toString()
                }
                Operations.MULTIPLICATION -> {
                    conclusion = ((f * l) * toMultiplicate).toString()
                }
                Operations.DIVIDE -> {
                    conclusion = if (l == 0.0) {
                        DIVIDE_EXCEPTION
                    } else {
                        ((f / l) * toMultiplicate).toString()
                    }
                }
                else -> {}
            }

            return processingConclusion(conclusion, l)
        }
        return null
    }

    fun processingEquality(): String? {
        if (last.isNotEmpty() && last != MINUS.toString()) {

            first = commaToPoint(first)
            last = commaToPoint(last)

            val f: Double = first.toDouble()
            val l: Double = last.toDouble()
            var conclusion = EMPTY

            when (operation) {
                Operations.PLUS -> conclusion = (f + l).toString()
                Operations.MINUS -> conclusion = (f - l).toString()
                Operations.MULTIPLICATION -> conclusion = (f * l).toString()
                Operations.DIVIDE -> {
                    conclusion = if (l == 0.0) {
                        DIVIDE_EXCEPTION
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