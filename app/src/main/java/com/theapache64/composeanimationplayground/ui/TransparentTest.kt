package com.theapache64.composeanimationplayground.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun App() {
    Box {
        var isTransparent by remember { mutableStateOf(false) }
        val transition = updateTransition(targetState = isTransparent, label = "My Animation")
        transition.AnimatedContent {
            if (isTransparent) {
                /**
                 * 💥 Here the app will crash because the lock didn't release by else block's RedScreen since its being animated.
                 */
                RedScreen()
                GreenScreen()
            } else {
                // Show only red
                RedScreen()
            }
        }

        Button(
            onClick = { isTransparent = !isTransparent },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp)
        ) {
            Text(text = "TOGGLE")
        }
    }
}

var lock = false
fun acquireLock() {
    check(!lock) { "Lock already taken" }
    lock = true
}

fun releaseLock() {
    lock = false
}

@Composable
fun RedScreen(
    modifier: Modifier = Modifier
) {
    DisposableEffect(Unit) {
        println("123: RedScreen created")
        acquireLock()
        onDispose {
            println("123: RedScreen destroyed")
            releaseLock()
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "I am RED", fontSize = 30.sp)
    }
}

@Composable
fun GreenScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Green.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "I am GREEN", fontSize = 30.sp)
    }
}