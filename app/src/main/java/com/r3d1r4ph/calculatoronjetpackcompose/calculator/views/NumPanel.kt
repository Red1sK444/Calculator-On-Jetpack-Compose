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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.RoundedCorner
import com.r3d1r4ph.calculatoronjetpackcompose.R
import com.r3d1r4ph.calculatoronjetpackcompose.utils.Result
import com.r3d1r4ph.calculatoronjetpackcompose.utils.extract

@Composable
fun NumPanel(numPanelLiveData: LiveData<Result>) {
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
                .neu(
                    lightShadowColor = Color.DarkGray,
                    darkShadowColor = Color.DarkGray,
                    shadowElevation = 1.dp,
                    lightSource = LightSource.RIGHT_BOTTOM,
                    shape = com.gandiva.neumorphic.shape.Pressed(RoundedCorner(10.dp))
                )
        )
        Box(
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = stringResource(id = R.string.num_panel_hint),
                color = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .alpha(0.08f),
                style = MaterialTheme.typography.body2
            )

            val textResult by numPanelLiveData.observeAsState(
                initial = Result.Success(
                    stringResource(id = R.string.zero)
                )
            )

            Text(
                text = when (textResult) {
                    is Result.Success -> textResult.extract().toString()
                    is Result.Exception -> textResult.extract().toString()
                },
                color = when (textResult) {
                    is Result.Success -> MaterialTheme.colors.secondary
                    is Result.Exception -> MaterialTheme.colors.error
                },
                maxLines = 1,
                style = MaterialTheme.typography.body2
            )
        }
    }
}