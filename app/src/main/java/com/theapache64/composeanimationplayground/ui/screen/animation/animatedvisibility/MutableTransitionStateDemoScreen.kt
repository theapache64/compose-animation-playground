package com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.ExperimentalTransitionApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo

@ExperimentalTransitionApi
@Composable
fun MutableTransitionStateDemoScreen() {
    val animationState = remember {
        MutableTransitionState(false)
    }

    BigColumn {
        AnimatedVisibility(
            visibleState = animationState,
            enter = fadeIn(animationSpec = tween(2000)),
            exit = fadeOut(animationSpec = tween(2000))
        ) {
            TeslaLogo()
        }

        val status = when {
            animationState.isIdle && animationState.currentState -> "Visible"
            !animationState.isIdle && animationState.currentState -> "Disappearing..."
            animationState.isIdle && !animationState.currentState -> "Invisible"
            else -> "Appearing..."
        }

        Text(text = "Status : $status", modifier = Modifier.padding(vertical = 10.dp))

        Button(onClick = {
            animationState.targetState = !animationState.currentState
        }) {
            Text(text = "Toggle")
        }
    }
}