package com.r3d1r4ph.calculatoronjetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val calculator = CalculatorProcessing()

    private val _padText = MutableLiveData<String>()
    val padText: LiveData<String>
        get() = _padText

    fun clickOnNumPad(buttonSymbol: String) {
        when {
            Regex("[0-9]").matches(buttonSymbol) -> clickOnDigit(buttonSymbol)
            Regex("[-X+/÷]").matches(buttonSymbol) -> clickOnOperation(buttonSymbol)
        }
        when(buttonSymbol) {
            "AC" -> clickOnAC()
            "," -> clickOnComma()
            "+/-" -> clickOnPlusMinus()
            "%" -> clickOnPercent()
            "=" -> clickOnEquality()
        }
    }

    private fun clickOnDigit(digit: String) {
        _padText.value = calculator.clickOnDigit(digit)
    }

    fun clickOnOperation(operation: String) {
        calculator.clickOnOperation(operation)?.let { _padText.value = it }
    }

    private fun clickOnAC() {
        _padText.value = calculator.processingAC(padText.value.toString())
    }

    private fun clickOnComma() {
        calculator.processingComma()?.let { _padText.value = it }
    }

    private fun clickOnPlusMinus() {
        _padText.value = calculator.processingPlusMinus()
    }

    private fun clickOnPercent() {
        calculator.processingPercent()?.let {
            _padText.value = if (it == "=/0") {
                "CAN'T DIVIDE"
            } else {
                it
            }
        }
    }

    fun clickOnEquality() {
        calculator.processingEquality()?.let {
            _padText.value = if (it == "=/0") {
                "CAN'T DIVIDE"
            } else {
                it
            }
        }
    }
}