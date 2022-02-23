package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButtons

@Composable
fun NumPad(onClick: (NumPadButtons) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        ButtonRowHolder(
            symbol1 = NumPadButtons.AC,
            symbol2 = NumPadButtons.PLUS_MINUS,
            symbol3 = NumPadButtons.PERCENT,
            symbol4 = NumPadButtons.DIVIDE,
            isFirstButtonWide = false,
            onClick = onClick
        )

        ButtonRowHolder(
            symbol1 = NumPadButtons.SEVEN,
            symbol2 = NumPadButtons.EIGHT,
            symbol3 = NumPadButtons.NINE,
            symbol4 = NumPadButtons.MULTIPLY,
            isFirstButtonWide = false,
            onClick = onClick
        )

        ButtonRowHolder(
            symbol1 = NumPadButtons.FOUR,
            symbol2 = NumPadButtons.FIVE,
            symbol3 = NumPadButtons.SIX,
            symbol4 = NumPadButtons.MINUS,
            isFirstButtonWide = false,
            onClick = onClick
        )

        ButtonRowHolder(
            symbol1 = NumPadButtons.ONE,
            symbol2 = NumPadButtons.TWO,
            symbol3 = NumPadButtons.THREE,
            symbol4 = NumPadButtons.PLUS,
            isFirstButtonWide = false,
            onClick = onClick
        )

        ButtonRowHolder(
            symbol1 = NumPadButtons.ZERO,
            symbol2 = NumPadButtons.EMPTY,
            symbol3 = NumPadButtons.COMMA,
            symbol4 = NumPadButtons.EQUALITY,
            isFirstButtonWide = true,
            onClick = onClick
        )
    }
}