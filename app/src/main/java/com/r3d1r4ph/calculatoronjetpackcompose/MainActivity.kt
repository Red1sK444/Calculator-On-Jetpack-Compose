package com.r3d1r4ph.calculatoronjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.CalculatorOnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorOnJetpackComposeTheme {
                Calculator()
            }
        }
    }
}

@Preview
@Composable
fun Calculator() {
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
            NumPanel()
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            NumPad()
        }
    }
}

@Composable
fun Label() {
    Text(
        text = "Calculator",
        style = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.W500,
            color = colorResource(id = R.color.heavy_black)
        )
    )
}

@Composable
fun NumPanel() {
    Image(
        painter = painterResource(id = R.drawable.bg_panel),
        contentDescription = "panel",
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp),
                clip = true
            )
    )
}

@Composable
fun NumPad() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WhiteButton(text = "AC")
            WhiteButton(text = "+/-")
            WhiteButton(text = "%")
            BlueButton(text = "/")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WhiteButton(text = "7")
            WhiteButton(text = "8")
            WhiteButton(text = "9")
            BlueButton(text = "X")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WhiteButton(text = "4")
            WhiteButton(text = "5")
            WhiteButton(text = "6")
            BlueButton(text = "-")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WhiteButton(text = "1")
            WhiteButton(text = "2")
            WhiteButton(text = "3")
            BlueButton(text = "+")
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WideWhiteButton(text = "0")
            WhiteButton(text = ",")
            BlueButton(text = "=")
        }
    }
}

@Composable
fun WhiteButton(text: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.white_bg)
        ),
        modifier = Modifier
            .size(80.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 29.sp,
                fontWeight = FontWeight.W700,
                color = colorResource(id = R.color.dark_blue)
            )
        )
    }
}

@Composable
fun WideWhiteButton(text: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.white_bg)
        ),
        modifier = Modifier
            .size(
                height = 80.dp,
                width = 168.dp
            ),
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 29.sp,
                fontWeight = FontWeight.W700,
                color = colorResource(id = R.color.dark_blue)
            )
        )
    }
}

@Composable
fun BlueButton(text: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.dark_blue)
        ),
        modifier = Modifier.size(80.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 29.sp,
                fontWeight = FontWeight.W700,
                color = colorResource(id = R.color.white)
            )
        )
    }
}

