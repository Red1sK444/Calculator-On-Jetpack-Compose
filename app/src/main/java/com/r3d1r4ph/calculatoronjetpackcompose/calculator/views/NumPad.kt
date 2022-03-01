package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButtons

@Composable
fun NumPad(numPadButtons: List<List<NumPadButtons>>, onClick: (NumPadButtons) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(numPadButtons) { buttonRow ->
            ButtonRowHolder(
                symbol1 = buttonRow[0],
                symbol2 = buttonRow[1],
                symbol3 = buttonRow[2],
                symbol4 = buttonRow[3],
                isFirstButtonWide = buttonRow[1] == NumPadButtons.EMPTY,
                onClick = onClick
            )
        }
    }
}