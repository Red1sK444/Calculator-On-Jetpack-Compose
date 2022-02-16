package com.r3d1r4ph.calculatoronjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.CalculatorOnJetpackComposeTheme
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Punched

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
//            Spacer(
//                modifier = Modifier.height(20.dp)
//            )
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
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "AC")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "+/-")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "%")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "/")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "7")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "8")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "9")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "X")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "4")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "5")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "6")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "-")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "1")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "2")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "3")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "+")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(2.2f)) {
                WideWhiteButton(text = "0")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = ",")
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "=")
            }
        }
    }
}

@Composable
fun WhiteButton(text: String) {
    NeuButton(isWhite = true, isWide = false, text = text)
}

@Composable
fun WideWhiteButton(text: String) {
    NeuButton(isWhite = true, isWide = true, text = text)
}

@Composable
fun BlueButton(text: String) {
    NeuButton(isWhite = false, isWide = false, text = text)
}

@Composable
fun NeuButton(isWhite: Boolean, isWide: Boolean, text: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(
                id = if (isWhite) R.color.white_bg else R.color.dark_blue
            )
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
            style = TextStyle(
                fontSize = 29.sp,
                fontWeight = FontWeight.W700,
                color = colorResource(
                    id = if (isWhite) R.color.dark_blue else R.color.white
                )
            )
        )
    }
}

