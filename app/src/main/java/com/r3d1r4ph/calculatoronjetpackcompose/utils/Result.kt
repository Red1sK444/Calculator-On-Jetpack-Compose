package com.r3d1r4ph.calculatoronjetpackcompose.utils

sealed class Result {
    data class Success(val expression: String) : Result()
    data class Exception(val exception: ArithmeticException) : Result()
}

fun Result.extract() =
    when (this) {
        is Result.Success -> expression
        is Result.Exception -> exception.message
    }
