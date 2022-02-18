package com.r3d1r4ph.calculatoronjetpackcompose.calculator.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.unit.dp
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched

@Composable
fun WhiteButton(
    text: String,
    onClick: (String) -> Unit
) {
    NeuButton(isWhite = true, text = text, onClick = onClick)
}

@Composable
fun BlueButton(
    text: String,
    onClick: (String) -> Unit
) {
    NeuButton(isWhite = false, text = text, onClick = onClick)
}

@Composable
fun NeuButton(
    isWhite: Boolean,
    text: String,
    onClick: (String) -> Unit
) {
    Button(
        onClick = { /*Log.d("MyLog", "pushed")*/ onClick.invoke(text) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isWhite) MaterialTheme.colors.background else MaterialTheme.colors.primary
        ),
        border = BorderStroke(0.dp, Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 80.dp)
            .neumorphic(
                neuShape = Punched.Rounded(radius = 20.dp),
                elevation = 10.dp
            ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h1,
            color = if (isWhite) MaterialTheme.colors.primary else Color.White
        )
    }
}