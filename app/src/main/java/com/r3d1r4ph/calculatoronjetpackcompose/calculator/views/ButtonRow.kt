package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.components.BlueButton
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.components.WhiteButton
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButton

@Composable
fun ButtonRow(
    wButton1: NumPadButton,
    wButton2: NumPadButton,
    wButton3: NumPadButton,
    bButton: NumPadButton,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.weight(wButton1.weight)) {
            WhiteButton(text = wButton1.symbol, onClick = onClick)
        }
        Spacer(modifier = Modifier.weight(0.2f))
        if (wButton2.weight > 0) {
            Box(modifier = Modifier.weight(wButton2.weight)) {
                WhiteButton(text = wButton2.symbol, onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
        }
        Box(modifier = Modifier.weight(wButton3.weight)) {
            WhiteButton(text = wButton3.symbol, onClick = onClick)
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Box(modifier = Modifier.weight(bButton.weight)) {
            BlueButton(text = bButton.symbol, onClick = onClick)
        }
    }
}

@Composable
fun ButtonRowHolder(
    symbol1: String,
    symbol2: String,
    symbol3: String,
    symbol4: String,
    isFirstButtonWide: Boolean,
    onClick: (String) -> Unit
) {
    ButtonRow(
        wButton1 = NumPadButton(
            weight = if (!isFirstButtonWide) 1f else 2.2f,
            symbol = symbol1
        ),
        wButton2 = NumPadButton(
            weight = if (!isFirstButtonWide) 1f else 0f,
            symbol = symbol2
        ),
        wButton3 = NumPadButton(
            weight = 1f,
            symbol = symbol3
        ),
        bButton = NumPadButton(
            weight = 1f,
            symbol = symbol4
        ),
        onClick = onClick
    )
}