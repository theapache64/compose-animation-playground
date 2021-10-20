package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo


@SuppressLint("UnrememberedMutableState")
@Composable
fun AnimateFloatAsStateDemo(
    isOn: Boolean
) {
    val targetValue = if (isOn) 0f else 100f
    val animatedValue by animateFloatAsState(targetValue = targetValue)

    TeslaLogo(
        modifier = Modifier.padding(start = animatedValue.dp)
    )
}
