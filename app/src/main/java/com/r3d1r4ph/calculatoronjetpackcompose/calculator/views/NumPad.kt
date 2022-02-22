package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.r3d1r4ph.calculatoronjetpackcompose.R
import com.r3d1r4ph.calculatoronjetpackcompose.calculator.models.NumPadButton

@Composable
fun NumPad(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        ButtonRowHolder(
            symbol1 = stringResource(id = R.string.ac),
            symbol2 = "+/-",
            symbol3 = "%",
            symbol4 = "÷",
            isFirstButtonWide = false,
            onClick = onClick
        )

//        ButtonRow(
//            wButton1 = NumPadButton(
//                weight = 1f,
//                symbol = stringResource(id = R.string.ac)
//            ),
//            wButton2 = NumPadButton(
//                weight = 1f,
//                symbol = "+/-"
//            ),
//            wButton3 = NumPadButton(
//                weight = 1f,
//                symbol = "%"
//            ),
//            bButton = NumPadButton(
//                weight = 1f,
//                symbol = "÷"
//            ),
//            onClick = onClick
//        )

        ButtonRowHolder(
            symbol1 = "7",
            symbol2 = "8",
            symbol3 = "9",
            symbol4 = "X",
            isFirstButtonWide = false,
            onClick = onClick
        )

//        ButtonRow(
//            wButton1 = NumPadButton(
//                weight = 1f,
//                symbol = "7"
//            ),
//            wButton2 = NumPadButton(
//                weight = 1f,
//                symbol = "8"
//            ),
//            wButton3 = NumPadButton(
//                weight = 1f,
//                symbol = "9"
//            ),
//            bButton = NumPadButton(
//                weight = 1f,
//                symbol = "X"
//            ),
//            onClick = onClick
//        )

        ButtonRowHolder(
            symbol1 = "4",
            symbol2 = "5",
            symbol3 = "6",
            symbol4 = "-",
            isFirstButtonWide = false,
            onClick = onClick
        )

//        ButtonRow(
//            wButton1 = NumPadButton(
//                weight = 1f,
//                symbol = "4"
//            ),
//            wButton2 = NumPadButton(
//                weight = 1f,
//                symbol = "5"
//            ),
//            wButton3 = NumPadButton(
//                weight = 1f,
//                symbol = "6"
//            ),
//            bButton = NumPadButton(
//                weight = 1f,
//                symbol = "-"
//            ),
//            onClick = onClick
//        )

        ButtonRowHolder(
            symbol1 = "1",
            symbol2 = "2",
            symbol3 = "3",
            symbol4 = "+",
            isFirstButtonWide = false,
            onClick = onClick
        )

//        ButtonRow(
//            wButton1 = NumPadButton(
//                weight = 1f,
//                symbol = "1"
//            ),
//            wButton2 = NumPadButton(
//                weight = 1f,
//                symbol = "2"
//            ),
//            wButton3 = NumPadButton(
//                weight = 1f,
//                symbol = "3"
//            ),
//            bButton = NumPadButton(
//                weight = 1f,
//                symbol = "+"
//            ),
//            onClick = onClick
//        )

        ButtonRowHolder(
            symbol1 = "0",
            symbol2 = stringResource(id = R.string.empty),
            symbol3 = ",",
            symbol4 = "=",
            isFirstButtonWide = true,
            onClick = onClick
        )

//        ButtonRow(
//            wButton1 = NumPadButton(
//                weight = 2.2f,
//                symbol = "0"
//            ),
//            wButton2 = NumPadButton(
//                weight = 0f,
//                symbol = stringResource(id = R.string.empty)
//            ),
//            wButton3 = NumPadButton(
//                weight = 1f,
//                symbol = ","
//            ),
//            bButton = NumPadButton(
//                weight = 1f,
//                symbol = "="
//            ),
//            onClick = onClick
//        )
    }
}