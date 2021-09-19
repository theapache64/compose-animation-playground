package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

private enum class BoxState {
    SMALL, MEDIUM, LARGE
}

@Preview
@Composable
fun UpdateTransitionScreen() {
    BigColumn {
        var currentState by remember { mutableStateOf(BoxState.SMALL) }
        val transition = updateTransition(targetState = currentState, "Box (Size + Color)")
        val size by transition.animateDp(label = "Size transition") {
            when (it) {
                BoxState.SMALL -> 100.dp
                BoxState.MEDIUM -> 200.dp
                BoxState.LARGE -> 350.dp
            }
        }

        val color by transition.animateColor(label = "Color transition") {
            when (it) {
                BoxState.SMALL -> Color.Red
                BoxState.MEDIUM -> Color.Green
                BoxState.LARGE -> Color.Blue
            }
        }

        Box(
            modifier = Modifier
                .size(size)
                .background(color = color)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {

            Button(onClick = { currentState = BoxState.SMALL }) {
                Text(text = "SMALL RED")
            }

            Button(onClick = { currentState = BoxState.MEDIUM }) {
                Text(text = "MEDIUM GREEN")
            }

            Button(onClick = { currentState = BoxState.LARGE }) {
                Text(text = "LARGE BLUE")
            }


        }
    }
}