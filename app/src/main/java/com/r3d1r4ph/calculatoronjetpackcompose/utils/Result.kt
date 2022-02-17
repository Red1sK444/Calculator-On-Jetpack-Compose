package com.r3d1r4ph.calculatoronjetpackcompose.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import java.lang.Exception

sealed class Result {
    data class Success(val expression: String) : Result()
    data class Exception(val exceptionId: Int) : Result()
}

fun Result.extract() =
    when (this) {
        is Result.Success -> expression
        is Result.Exception -> exceptionId
    }
