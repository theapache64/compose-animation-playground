package com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

@Composable
fun DefaultDemoScreen() {
    BigColumn {
        var count by remember { mutableStateOf(0) }
        AnimatedContent(
            targetState = count,
        ) { targetCount ->
            Text(text = "Count : $targetCount", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { count++ }) {
            Text(text = "Add")
        }
    }
}