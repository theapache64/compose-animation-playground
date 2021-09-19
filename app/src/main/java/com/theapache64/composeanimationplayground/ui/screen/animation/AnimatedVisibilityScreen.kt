package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.theapache64.composeanimationplayground.model.AnimationItem
import com.theapache64.composeanimationplayground.ui.composable.AnimationItem
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.*

const val DURATION = 2000

private val animations: List<AnimationItem> by lazy {
    mutableListOf(
        AnimationItem(
            title = "Default",
            description = "Content appears by fading in and expanding, and it disappears by fading out and shrinking"
        ) { isVisible ->
            DefaultDemo(isVisible)
        },

        AnimationItem(
            title = "fadeIn + fadeOut",
            description = "Content appears by fading in, and it disappears by fading out"
        ) { isVisible ->
            FadeInFadeOutDemo(isVisible)
        },

        AnimationItem(
            title = "slideIn + slideOut",
            description = "Content appears by sliding in, and it disappears by sliding out"
        ) { isVisible ->
            SlideInOutDemo(isVisible)
        },

        AnimationItem(
            title = "slideIn/slideOut horizontally",
            description = "Content appears by sliding in horizontally, and it disappears by sliding out horizontally"
        ) { isVisible ->
            SlideInOutHorizontallyDemo(isVisible)
        },

        AnimationItem(
            title = "slideIn/slideOut vertically",
            description = "Content appears by sliding in vertically, and it disappears by sliding out vertically"
        ) { isVisible ->
            SlideInOutVerticallyDemo(isVisible)
        },

        AnimationItem(
            title = "scaleIn + scaleOut",
            description = "Content appears by scaling in, and it disappears by scaling out"
        ) { isVisible ->
            ScaleInOutDemo(isVisible)
        },

        AnimationItem(
            title = "expandIn + shrinkOut",
            description = "Content appears by expanding in, and it disappears by shrinking out"
        ) { isVisible ->
            ExpandInShrinkOutDemo(isVisible)
        },

        AnimationItem(
            title = "expand/shrink horizontally",
            description = "Content appears by expanding in horizontally, and it disappears by shrinking out horizontally"
        ) { isVisible ->
            ExpandShrinkHorizontallyDemo(isVisible)
        },

        AnimationItem(
            title = "expand/shrink vertically",
            description = "Content appears by expanding in vertically, and it disappears by shrinking out vertically"
        ) { isVisible ->
            ExpandShrinkVerticallyDemo(isVisible)
        },

        AnimationItem(
            title = "animateEnterExit",
            description = "Using `animateEnterExit` method, you can add additional animations" +
                    " to the direct/indirect children of `AnimatedVisibility`. Pretty helpful" +
                    " when you want to inherit animations. "
        ) { isVisible ->
            AnimateEnterExitOnChildDemo(isVisible)
        },

        AnimationItem(
            title = "TransitionApiDemo",
            description = "Content appears by scale in with TeslaRed, and it disappears by scale out with transparent color"
        ) { isVisible ->
            TransitionApiDemo(isVisible)
        },

        AnimationItem(
            title = "Advanced Sample",
            description = "Content appears by slideIn + expandVertical + fadeIn, and it disappears by slideOut + shrinkVertical + fadeOut"
        ) { isVisible ->
            AnimatedVisibilityAdvancedDemo(isVisible)
        },
    )
}

@Composable
fun AnimatedVisibilityScreen(
    onBackClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "AnimatedVisibility")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClicked) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "go back")
                    }
                }
            )
        }
    ) {
        LazyColumn {
            itemsIndexed(animations) { index, animation ->
                AnimationItem(index, animation)
            }
        }
    }
}
