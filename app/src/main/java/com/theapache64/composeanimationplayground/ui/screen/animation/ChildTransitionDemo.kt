package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private enum class ColorBox { Red, Green, Blue }

private const val ANIM_DURATION = 3000

@OptIn(ExperimentalTransitionApi::class)
@Preview
@Composable
fun ChildTransitionDemo() {
    var colorBoxState by remember { mutableStateOf(ColorBox.Red) }
    val transition = updateTransition(colorBoxState, label = "My Animation")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {


        val redBoxTransition = transition.createChildTransition {
            it == ColorBox.Red
        }
        val greenBoxTransition = transition.createChildTransition {
            it == ColorBox.Green
        }
        val blueBoxTransition = transition.createChildTransition {
            it == ColorBox.Blue
        }

        RedBox(redBoxTransition)
        GreenBox(greenBoxTransition)
        BlueBox(blueBoxTransition)

        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Label(text = "boxState: $colorBoxState")
            Label(text = "redBoxTransition: ${redBoxTransition.isRunning}")
            Label(text = "greenBoxTransition: ${greenBoxTransition.isRunning}")
            Label(text = "blueBoxTransition: ${blueBoxTransition.isRunning}")

            Button(
                onClick = {
                    colorBoxState = when (colorBoxState) {
                        ColorBox.Red -> ColorBox.Green
                        ColorBox.Green -> ColorBox.Blue
                        ColorBox.Blue -> ColorBox.Red
                    }
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "TOGGLE")
            }
        }
    }
}

@Composable
fun Label(text: String) {
    Text(
        text = text,
        fontSize = 30.sp
    )
}

@Composable
fun RedBox(transition: Transition<Boolean>) {
    transition.AnimatedVisibility(
        visible = { it },
        enter = fadeIn(animationSpec = tween(ANIM_DURATION)),
        exit = fadeOut(animationSpec = tween(ANIM_DURATION))
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
        ) {}
    }
}

@Composable
fun GreenBox(
    transition: Transition<Boolean>
) {
    transition.AnimatedVisibility(
        visible = { it },
        enter = fadeIn(animationSpec = tween(ANIM_DURATION)),
        exit = fadeOut(animationSpec = tween(ANIM_DURATION))
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Green)
        ) {}
    }
}

@Composable
fun BlueBox(transition: Transition<Boolean>) {
    transition.AnimatedVisibility(
        visible = { it },
        enter = fadeIn(animationSpec = tween(ANIM_DURATION)),
        exit = fadeOut(animationSpec = tween(ANIM_DURATION))
    ) {
        Box(
            modifier = Modifier
                .size(250.dp)
                .background(Color.Blue)
        ) {}
    }
}