package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.theapache64.composeanimationplayground.model.AnimationItem
import com.theapache64.composeanimationplayground.ui.composable.AnimationItem
import com.theapache64.composeanimationplayground.ui.screen.animation.animateproperty.AnimateFloatAsStateDemo

private val animations: List<AnimationItem> by lazy {
    mutableListOf(
        // TODO: Float, Color, Dp, Size, Bounds, Offset, Rect, Int, IntOffset, and IntSize, AnimateShape (Rectangle to Triangle)
        AnimationItem(
            title = "animateFloatAsState",
            description = "animates the float value"
        ) { isOn ->
            AnimateFloatAsStateDemo(isOn)
        },
    )
}


@Composable
fun AnimatePropertyAsStateScreen(
    onBackClicked: () -> Unit
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
                AnimationItem(index, animation)
            }
        }
    }
}
