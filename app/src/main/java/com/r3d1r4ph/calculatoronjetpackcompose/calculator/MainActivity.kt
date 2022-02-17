package com.r3d1r4ph.calculatoronjetpackcompose.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.screens.CalculatorScreen
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.CalculatorOnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorOnJetpackComposeTheme {
                CalculatorScreen()
            }
        }
    }
}

