package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.r3d1r4ph.calculatoronjetpackcompose.R

@Composable
fun Label() {
    Text(
        text = "Calculator",
        style = MaterialTheme.typography.h2,
        color = colorResource(id = R.color.heavy_black)
    )
}