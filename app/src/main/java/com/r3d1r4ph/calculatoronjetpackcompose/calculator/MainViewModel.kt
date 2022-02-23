package com.r3d1r4ph.calculatoronjetpackcompose.calculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.r3d1r4ph.calculatoronjetpackcompose.model.CalculatorProcessing
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButtons
import com.r3d1r4ph.calculatoronjetpackcompose.utils.CantDivideException
import com.r3d1r4ph.calculatoronjetpackcompose.utils.Result

class MainViewModel : ViewModel() {

    companion object {
        private const val DIVIDE_EXCEPTION = "=/0"
        private const val DIVIDE_EXCEPTION_TO_SH0W = "CAN'T DIVIDE"
    }

    private val calculator = CalculatorProcessing()

    private val _padText = MutableLiveData<Result>()
    val padText: LiveData<Result>
        get() = _padText

    fun clickOnNumPad(buttonSymbol: NumPadButtons) {
        when (NumPadButtons.valueOf(buttonSymbol.toString())) {
            NumPadButtons.AC -> clickOnAC()
            NumPadButtons.COMMA -> clickOnComma()
            NumPadButtons.PLUS_MINUS -> clickOnPlusMinus()
            NumPadButtons.PERCENT -> clickOnPercent()
            NumPadButtons.EQUALITY -> clickOnEquality()
            NumPadButtons.MINUS, NumPadButtons.MULTIPLY,
            NumPadButtons.DIVIDE, NumPadButtons.PLUS -> clickOnOperation(
                buttonSymbol
            )
            else -> clickOnDigit(
                buttonSymbol.symbol
            )
        }
    }

    private fun clickOnDigit(digit: String) {
        _padText.value = Result.Success(expression = calculator.clickOnDigit(digit))
    }

    private fun clickOnOperation(operation: NumPadButtons) {
        calculator.clickOnOperation(operation)
            ?.let {
                _padText.value = Result.Success(expression = it)
            }
    }

    private fun clickOnAC() {
        _padText.value = Result.Success(expression = calculator.processingAC())
    }

    private fun clickOnComma() {
        calculator.processingComma()?.let {
            _padText.value = Result.Success(expression = it)
        }
    }

    private fun clickOnPlusMinus() {
        _padText.value = Result.Success(expression = calculator.processingPlusMinus())
    }

    private fun clickOnPercent() {
        calculator.processingPercent()?.let {
            _padText.value = if (it == DIVIDE_EXCEPTION) {
                Result.Exception(exception = CantDivideException(DIVIDE_EXCEPTION_TO_SH0W))
            } else {
                Result.Success(expression = it)
            }
        }
    }

    private fun clickOnEquality() {
        calculator.processingEquality()?.let {
            _padText.value = if (it == DIVIDE_EXCEPTION) {
                Result.Exception(exception = CantDivideException(DIVIDE_EXCEPTION_TO_SH0W))
            } else {
                Result.Success(expression = it)
            }
        }
    }
}