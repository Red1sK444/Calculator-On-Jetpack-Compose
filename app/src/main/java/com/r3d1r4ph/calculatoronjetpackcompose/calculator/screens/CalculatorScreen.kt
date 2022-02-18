package com.r3d1r4ph.calculatoronjetpackcompose.calculator.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.MainViewModel
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.views.CalculatorView

@Composable
fun CalculatorScreen(viewModel: MainViewModel = MainViewModel()) {
    CalculatorView(
        numPanelLiveData = viewModel.padText,
        numPadOnClick = {
            viewModel.clickOnNumPad(it)
        }
    )
}

@Preview
@Composable
fun CalculatorPreview() {
    CalculatorScreen()
}