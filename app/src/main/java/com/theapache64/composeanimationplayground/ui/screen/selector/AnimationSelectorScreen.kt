package com.theapache64.composeanimationplayground.ui.screen.selector

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.model.AnimationScreen

@Composable
fun AnimationSelector(
    animations : List<AnimationScreen>,
    onAnimationSelected: (AnimationScreen) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Animation Selector")
            })
        }
    ) {

        LazyColumn {
            items(animations) { animation ->
                AnimationSelectorItem(
                    animation,
                    onClicked = onAnimationSelected
                )
            }
        }
    }
}

@Composable
fun AnimationSelectorItem(
    animation: AnimationScreen,
    onClicked: (AnimationScreen) -> Unit
) {
    Column {

        Text(
            text = animation.title,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClicked(animation) }
                .padding(16.dp)
        )

        Divider()
    }
}
