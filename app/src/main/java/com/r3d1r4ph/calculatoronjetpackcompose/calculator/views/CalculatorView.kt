package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButtons
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.components.Label
import com.r3d1r4ph.calculatoronjetpackcompose.utils.Result

@Composable
fun CalculatorView(numPanelLiveData: LiveData<Result>, numPadOnClick: (NumPadButtons) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Spacer(
                modifier = Modifier.height(25.dp)
            )
            Label()
            Spacer(
                modifier = Modifier.height(24.dp)
            )
            NumPanel(numPanelLiveData)
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            NumPad(numPadOnClick)
        }
    }
}