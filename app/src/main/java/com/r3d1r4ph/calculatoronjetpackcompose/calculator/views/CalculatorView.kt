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
            NumPad(
                numPadButtons = listOf(
                    listOf(
                        NumPadButtons.AC,
                        NumPadButtons.PLUS_MINUS,
                        NumPadButtons.PERCENT,
                        NumPadButtons.DIVIDE
                    ),
                    listOf(
                        NumPadButtons.SEVEN,
                        NumPadButtons.EIGHT,
                        NumPadButtons.NINE,
                        NumPadButtons.MULTIPLY
                    ),
                    listOf(
                        NumPadButtons.FOUR,
                        NumPadButtons.FIVE,
                        NumPadButtons.SIX,
                        NumPadButtons.MINUS
                    ),
                    listOf(
                        NumPadButtons.ONE,
                        NumPadButtons.TWO,
                        NumPadButtons.THREE,
                        NumPadButtons.PLUS
                    ),
                    listOf(
                        NumPadButtons.ZERO,
                        NumPadButtons.EMPTY,
                        NumPadButtons.COMMA,
                        NumPadButtons.EQUALITY
                    )
                ),
                onClick = numPadOnClick
            )
        }
    }
}