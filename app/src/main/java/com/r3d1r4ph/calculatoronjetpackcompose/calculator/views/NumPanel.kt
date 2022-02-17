package com.r3d1r4ph.calculatoronjetpackcompose.calculator.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.r3d1r4ph.calculatoronjetpackcompose.R
import com.r3d1r4ph.calculatoronjetpackcompose.utils.Result
import com.r3d1r4ph.calculatoronjetpackcompose.utils.extract
import me.nikhilchaudhari.library.neumorphic
import me.nikhilchaudhari.library.shapes.Pressed

@Composable
fun NumPanel(numPanelText: LiveData<Result>) {
    val text by numPanelText.observeAsState(initial = Result.Success("0"))

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_panel),
            contentDescription = stringResource(id = R.string.empty),
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
                text = stringResource(id = R.string.num_panel_hint),
                color = colorResource(id = R.color.heavy_black),
                modifier = Modifier
                    .alpha(0.08f),
                style = MaterialTheme.typography.body2
            )
            Text(
                text = when (text) {
                    is Result.Success -> text.extract().toString()
                    is Result.Exception -> stringResource(id = text.extract() as Int)
                },
                color = when (text) {
                    is Result.Success -> colorResource(id = R.color.heavy_black)
                    is Result.Exception -> colorResource(id = R.color.red)
                },
                maxLines = 1,
                style = MaterialTheme.typography.body2
            )
        }
    }
}