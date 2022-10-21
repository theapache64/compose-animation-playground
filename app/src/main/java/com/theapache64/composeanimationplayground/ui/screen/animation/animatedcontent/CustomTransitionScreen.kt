package com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

private const val FLY_RANGE = 500

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomTransitionScreen() {
    BigColumn {
        var count by remember { mutableStateOf(0) }
        AnimatedContent(
            targetState = count,
            transitionSpec = {
                if (targetState > initialState) {
                    /**
                     * INCREMENT ANIMATION:
                     * Incremented value should slideIn from top (-ve fly range) with fadeIn effect.
                     * When the value is incremented again, current value should slideOut to bottom (+ve fly range) and fadeOut.
                     */
                    slideInVertically{ -FLY_RANGE } + fadeIn() with slideOutVertically{ FLY_RANGE } + fadeOut()
                } else {
                    /**
                     * DECREMENT ANIMATION:
                     * Decremented value should slideIn from bottom (+ve fly range) with fadeIn effect.
                     * When the value decremented again, current value should slideOut to top (-ve fly range) and fadeOut
                     */
                    slideInVertically{ FLY_RANGE } + fadeIn() with slideOutVertically{ -FLY_RANGE } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            Text(
                text = targetCount.toString(),
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Button(onClick = { count++ }) {
                Text(text = "Increment")
            }

            Button(onClick = { count-- }) {
                Text(text = "Decrement")
            }
        }
    }
}