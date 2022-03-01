package com.r3d1r4ph.calculatoronjetpackcompose.utils

sealed class Result {
    data class Success(val expression: String) : Result()
    data class Exception(val exception: CantDivideException) : Result()
}
