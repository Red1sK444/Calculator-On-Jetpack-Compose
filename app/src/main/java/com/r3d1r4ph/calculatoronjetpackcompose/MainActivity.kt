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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.r3d1r4ph.calculatoronjetpackcompose.ui.theme.CalculatorOnJetpackComposeTheme
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed
import me.nikhilchaudhari.library.shapes.Punched

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

@Preview
@Composable
fun CalculatorPreview() {
    CalculatorScreen()
}

@Composable
fun CalculatorScreen(viewModel: MainViewModel = MainViewModel()) {
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
            NumPanel(viewModel.padText)
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            NumPad { symbol -> viewModel.clickOnNumPad(symbol) }
        }
    }
}

@Composable
fun Label() {
    Text(
        text = "Calculator",
        style = TextStyle(
            fontSize = 28.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W700,
            color = colorResource(id = R.color.heavy_black)
        )
    )
}

@Composable
fun NumPanel(padTextLiveData: LiveData<String>) {
    val padText by padTextLiveData.observeAsState("")
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_panel),
            contentDescription = "panel",
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .neumorphic(
                    neuShape = Pressed.Rounded(10.dp),
                    elevation = 1.dp,
                    lightShadowColor = Color.DarkGray,
                    darkShadowColor = Color.DarkGray,
                    strokeWidth = 1.dp
                )
        )
        Box(
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = "8888888888",
                fontFamily = FontFamily(
                    Font(
                        R.font.digital_7_mono,
                        FontWeight.Normal
                    )
                ),
                color = colorResource(id = R.color.heavy_black),
                fontSize = 60.sp,
                modifier = Modifier
                    .alpha(0.08f),
                textAlign = TextAlign.End
            )
            Text(
                text = padText,
                fontFamily = FontFamily(
                    Font(
                        R.font.digital_7_mono,
                        FontWeight.Normal
                    )
                ),
                color = colorResource(id = R.color.heavy_black),
                fontSize = 60.sp,
                textAlign = TextAlign.End
            )
        }
    }
}



@Composable
fun NumPad(onClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "AC", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "+/-", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "%", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "÷", onClick = onClick)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "7", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "8", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "9", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "X", onClick = onClick)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "4", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "5", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "6", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "-", onClick = onClick)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "1", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "2", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = "3", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "+", onClick = onClick)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.weight(2.2f)) {
                WideWhiteButton(text = "0", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                WhiteButton(text = ",", onClick = onClick)
            }
            Spacer(modifier = Modifier.weight(0.2f))
            Box(modifier = Modifier.weight(1f)) {
                BlueButton(text = "=", onClick = onClick)
            }
        }
    }
}

@Composable
fun WhiteButton(text: String,
                onClick: (String) -> Unit) {
    NeuButton(isWhite = true, isWide = false, text = text, onClick = onClick)
}

@Composable
fun WideWhiteButton(text: String,
                    onClick: (String) -> Unit) {
    NeuButton(isWhite = true, isWide = true, text = text, onClick = onClick)
}

@Composable
fun BlueButton(text: String,
               onClick: (String) -> Unit) {
    NeuButton(isWhite = false, isWide = false, text = text, onClick = onClick)
}

@Composable
fun NeuButton(
    isWhite: Boolean,
    isWide: Boolean,
    text: String,
    onClick: (String) -> Unit
) {
    Button(
        onClick = { onClick.invoke(text) },
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

