package com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.theapache64.composeanimationplayground.model.AnimationItem
import com.theapache64.composeanimationplayground.ui.composable.AnimationItem
import com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.rect.AnimateRectAsStateDemo

private val animations: List<AnimationItem> by lazy {
    mutableListOf(

        AnimationItem(
            title = "animateFloatAsState",
            description = "animates the float value"
        ) { isActive ->
            AnimateIntAsStateDemo(isActive)
        },

        AnimationItem(
            title = "animateColorAsState",
            description = "animates the color value"
        ) { isActive ->
            AnimateColorAsStateDemo(isActive)
        },

        AnimationItem(
            title = "animateDpAsState",
            description = "animates the dp value"
        ) { isActive ->
            AnimateDpAsStateDemo(isActive)
        },

        AnimationItem(
            title = "animateSizeAsState",
            description = "animates the size object"
        ) { isActive ->
            AnimateSizeAsStateDemo(isActive)
        },

        AnimationItem(
            title = "animateOffsetAsState",
            description = "animates the offset object"
        ) { isActive ->
            AnimateOffsetAsStateDemo(isActive)
        },

        AnimationItem(
            title = "animateRectAsState",
            description = "animates the rect object"
        ) { isActive ->
            AnimateRectAsStateDemo(isActive)
        },
        // TODO: IntOffset, and IntSize, AnimateShape (Rectangle to Triangle)
        AnimationItem(
            title = "animateIntAsState",
            description = "animates the int value"
        ) { isActive ->
            AnimateIntAsStateDemo(isActive)
        }
    )
}


@Composable
fun AnimatePropertyAsStateScreen(
    onBackClicked: () -> Unit,
    onItemClicked: (AnimationItem) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Animate*AsState")
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
                AnimationItem(index, animation, onItemClicked)
            }
        }
    }
}
