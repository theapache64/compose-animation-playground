package com.theapache64.composeanimationplayground.model

import androidx.compose.runtime.Composable

data class AnimationItem(
    val title: String,
    val description: String,
    val path : String? = null,
    val content: @Composable (isVisible: Boolean) -> Unit
)
