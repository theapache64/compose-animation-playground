package com.theapache64.composeanimationplayground.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
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
        if (!isTransparent) {
            AnimatedVisibility(visibleState = remember {
                MutableTransitionState(false)
            }.apply {
                targetState = true
            },
                enter = fadeIn()
            ) {
                RedScreen()
            }
        } else {
            RedScreen()
            AnimatedVisibility(
                visibleState = remember {
                    MutableTransitionState(false)
                }.apply {
                    targetState = true
                },
                enter = slideInHorizontally({ it }),
                exit = slideOutHorizontally({ -it })
            ) {
                GreenScreen()
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
        Text(text = "I am RED", fontSize = 50.sp)
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