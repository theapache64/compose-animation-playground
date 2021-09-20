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
        transition.AnimatedContent { isTrans ->
            if (isTrans) {
                // Show both red and green
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
fun lock() {
    check(!lock) { "Lock already taken" }
    lock = true
}

fun unlock() {
    lock = false
}

@Composable
fun RedScreen() {
    DisposableEffect(Unit) {
        println("123: RedScreen created")
        lock()
        onDispose {
            println("123: RedScreen destroyed")
            unlock()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "I am RED", fontSize = 30.sp)
    }
}

@Composable
fun GreenScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "I am GREEN", fontSize = 30.sp)
    }
}