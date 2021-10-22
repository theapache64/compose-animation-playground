package com.theapache64.composeanimationplayground.model

import androidx.compose.runtime.Composable

data class AnimationScreen(
    val title: String,
    val content: @Composable (
        onBackPressed: () -> Unit,
        onItemClicked: (AnimationItem) -> Unit
    ) -> Unit
)
