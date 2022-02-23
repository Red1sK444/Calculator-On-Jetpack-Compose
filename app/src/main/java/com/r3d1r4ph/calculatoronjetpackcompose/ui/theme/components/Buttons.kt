package com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.RoundedCorner
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButtons

@Composable
fun WhiteButton(
    text: NumPadButtons,
    onClick: (NumPadButtons) -> Unit
) {
    NeuButton(isWhite = true, text = text, onClick = onClick)
}

@Composable
fun BlueButton(
    text: NumPadButtons,
    onClick: (NumPadButtons) -> Unit
) {
    NeuButton(isWhite = false, text = text, onClick = onClick)
}

@Composable
fun NeuButton(
    isWhite: Boolean,
    text: NumPadButtons,
    onClick: (NumPadButtons) -> Unit
) {
    Button(
        onClick = { onClick.invoke(text) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isWhite) MaterialTheme.colors.background else MaterialTheme.colors.primary
        ),
        border = BorderStroke(
            0.dp,
            if (isWhite) MaterialTheme.colors.background else MaterialTheme.colors.primary
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 80.dp)
            .neu(
                lightShadowColor = Color.White,
                darkShadowColor = Color(0xFFA8B5C7),
                shadowElevation = 6.dp,
                lightSource = LightSource.LEFT_TOP,
                shape = Flat(RoundedCorner(20.dp))
            ),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = text.symbol,
            style = MaterialTheme.typography.h1,
            maxLines = 1,
            color = if (isWhite) MaterialTheme.colors.primary else Color.White
        )
    }
}