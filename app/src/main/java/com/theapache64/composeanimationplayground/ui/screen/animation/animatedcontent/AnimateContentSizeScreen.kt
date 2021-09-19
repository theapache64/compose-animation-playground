package com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AnimateContentSizeScreen() {
    var isExpanded by remember { mutableStateOf(false) }
    Box(
        Modifier.fillMaxSize(),
    ) {
        val size = if (isExpanded) 200.dp else 50.dp
        Box(modifier = Modifier
            .background(Brush.radialGradient(colors = listOf(Color.Red, Color.Black)))
            .animateContentSize()
            .size(size)
            .clickable {
                isExpanded = !isExpanded
            }
        )
    }
}