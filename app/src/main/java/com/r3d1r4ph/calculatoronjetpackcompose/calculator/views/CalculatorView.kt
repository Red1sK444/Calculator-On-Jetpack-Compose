package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.r3d1r4ph.calculatoronjetpackcompose.R
import com.r3d1r4ph.calculatoronjetpackcompose.utils.Result

@Composable
fun CalculatorView(numPanelText: LiveData<Result>, numPadOnClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white_bg))
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
            NumPanel(numPanelText)
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            NumPad(numPadOnClick)
        }
    }
}