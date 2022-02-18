package com.r3d1r4ph.calculatoronjetpackcompose.calculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.r3d1r4ph.calculatoronjetpackcompose.R
import com.r3d1r4ph.calculatoronjetpackcompose.model.CalculatorProcessing
import com.r3d1r4ph.calculatoronjetpackcompose.utils.Result
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    companion object {
        private const val DIVIDE_EXCEPTION = "=/0"
    }

    private val calculator = CalculatorProcessing()

    private val _padText = MutableLiveData<Result>()
    val padText: LiveData<Result>
        get() = _padText

//    private val _text = MutableLiveData<String>()
//    val text: LiveData<String>
//        get() = _text

    fun clickOnNumPad(buttonSymbol: String) {
        Log.d("MyLog", "pushed")
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
        viewModelScope.launch {
            _padText.value = Result.Success(expression = calculator.clickOnDigit(digit))
//            _text.value = calculator.clickOnDigit(digit)
        }
    }

    private fun clickOnOperation(operation: String) {
        viewModelScope.launch {
            calculator.clickOnOperation(operation)
                ?.let {
                    _padText.value = Result.Success(expression = it)
//                    _text.value = it
                }
        }
    }

    private fun clickOnAC() {
        _padText.value = Result.Success(expression = calculator.processingAC())
//        _text.value = calculator.processingAC()
    }

    private fun clickOnComma() {
        calculator.processingComma()?.let {
            _padText.value = Result.Success(expression = it)
//            _text.value = it
        }
    }

    private fun clickOnPlusMinus() {
        _padText.value = Result.Success(expression = calculator.processingPlusMinus())
//        _text.value = calculator.processingPlusMinus()
    }

    private fun clickOnPercent() {
        calculator.processingPercent()?.let {
            _padText.value = if (it == DIVIDE_EXCEPTION) {
                Result.Exception(exceptionId = R.string.divide_exception)
            } else {
                Result.Success(expression = it)
            }
//            _text.value = if (it == DIVIDE_EXCEPTION) {
//                "Cant divide"
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
//            _text.value = if (it == DIVIDE_EXCEPTION) {
//                "Cant divide"
//            } else {
//                it
//            }
        }
    }
}