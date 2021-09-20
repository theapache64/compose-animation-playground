package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn


enum class BoxStates {
    Red, Green, RedAndGreen
}

@Preview
@Composable
fun UpdateTransitionAnimateContentScreen() {
    BigColumn {

        val state = remember { MutableTransitionState(BoxStates.Red) }
        val transition =
            updateTransition(transitionState = state, label = "AnimateContent Sample")

        transition.AnimatedContent(
            transitionSpec = {
                println("Rendering...")
                slideInHorizontally(
                    initialOffsetX = { -it },
                    animationSpec = tween(2000)
                ) with slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(2000)
                )
            }
        ) { targetState ->
            when (targetState) {
                BoxStates.Red -> RedBox()
                BoxStates.Green -> GreenBox()
                BoxStates.RedAndGreen -> TODO()
            }
        }

        Row {
            Button(onClick = {
                val newState =
                    if (state.currentState == BoxStates.Red) BoxStates.Green else BoxStates.Red
                state.targetState = newState
            }) {
                Text(text = "TOGGLE: ${state.isIdle}")
            }
        }
    }
}

private val boxSize = 100.dp

@Composable
fun RedBox() {
    Box(
        modifier = Modifier
            .size(boxSize)
            .background(Color.Red.copy(alpha = 0.5f))
    )
}

@Composable
fun GreenBox() {
    Box(
        modifier = Modifier
            .size(boxSize)
            .background(Color.Green.copy(alpha = 0.5f))
    )
}

@Preview
@Composable
fun Test() {
    var isVisible by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isVisible, label = "My Animation")
    BigColumn {
        transition.AnimatedContent(
            transitionSpec = {
                fadeIn(animationSpec = tween(2000)) with
                        fadeOut(animationSpec = tween(2000))
            }
        ) { visible ->
            if (visible) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(300.dp)
                        .background(Color.Blue)
                )
            }
        }

        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "TOGGLE: ${transition.isRunning}")
        }
    }
}