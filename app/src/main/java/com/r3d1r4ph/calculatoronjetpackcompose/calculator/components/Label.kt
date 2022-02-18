package com.r3d1r4ph.calculatoronjetpackcompose.calculator.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.r3d1r4ph.calculatoronjetpackcompose.R

@Composable
fun Label() {
    Text(
        text = stringResource(id = R.string.label),
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.secondary
    )
}