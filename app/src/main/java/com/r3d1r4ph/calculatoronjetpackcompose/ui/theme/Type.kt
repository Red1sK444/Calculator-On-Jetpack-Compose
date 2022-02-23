package com.r3d1r4ph.calculatoronjetpackcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.r3d1r4ph.calculatoronjetpackcompose.R

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontSize = 29.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W700,
    ),
    h2 = TextStyle(
        fontSize = 28.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W700
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = FontFamily(
            Font(
                R.font.digital_7_mono,
                FontWeight.Normal
            )
        ),
        fontSize = 50.sp,
        textAlign = TextAlign.End
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)