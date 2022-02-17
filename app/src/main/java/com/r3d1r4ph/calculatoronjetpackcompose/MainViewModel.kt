package com.r3d1r4ph.calculatoronjetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.r3d1r4ph.calculatoronjetpackcompose.model.CalculatorProcessing

class MainViewModel : ViewModel() {

    companion object {
        private const val DIVIDE_EXCEPTION = "=/0"
    }

    private val calculator = CalculatorProcessing()

    private val _padText = MutableLiveData<Result>()
    val padText: LiveData<Result>
        get() = _padText

    fun clickOnNumPad(buttonSymbol: String) {
        when {
            Regex("[0-9]").matches(buttonSymbol) -> clickOnDigit(buttonSymbol)
            Regex("[-X+÷]").matches(buttonSymbol) -> clickOnOperation(buttonSymbol)
        }
        when (buttonSymbol) {
            "AC" -> clickOnAC()
            "," -> clickOnComma()
            "+/-" -> clickOnPlusMinus()
            "%" -> clickOnPercent()
            "=" -> clickOnEquality()
        }
    }

    private fun clickOnDigit(digit: String) {
        _padText.value = Result.Success(expression = calculator.clickOnDigit(digit))
        //       _padText.value = calculator.clickOnDigit(digit)
    }

    private fun clickOnOperation(operation: String) {
        calculator.clickOnOperation(operation)
            ?.let {
                _padText.value = Result.Success(expression = it)
                // _padText.value = it
            }
    }

    private fun clickOnAC() {
        _padText.value = Result.Success(expression = calculator.processingAC())
    }
//        _padText.value =
//            calculator.processingAC(padText.value.toString())

    private fun clickOnComma() {
        calculator.processingComma()?.let { _padText.value = Result.Success(expression = it) }
//        calculator.processingComma()?.let { _padText.value = it }
    }

    private fun clickOnPlusMinus() {
        _padText.value = Result.Success(expression = calculator.processingPlusMinus())
//        _padText.value = calculator.processingPlusMinus()
    }

    private fun clickOnPercent() {
        calculator.processingPercent()?.let {
            _padText.value = if (it == DIVIDE_EXCEPTION) {
                Result.Exception(exceptionId = R.string.divide_exception)
            } else {
                Result.Success(expression = it)
            }
//            _padText.value = if (it == DIVIDE_EXCEPTION) {
//                "CAN'T DIVIDE"
//            } else {
//                it
//            }
        }
    }

    private fun clickOnEquality() {
        calculator.processingEquality()?.let {
            _padText.value = if (it == DIVIDE_EXCEPTION) {
                Result.Exception(exceptionId = R.string.divide_exception)
            } else {
                Result.Success(expression = it)
            }
//            _padText.value = if (it == DIVIDE_EXCEPTION) {
//                "CAN'T DIVIDE"
//            } else {
//                it
//            }
        }
    }
}