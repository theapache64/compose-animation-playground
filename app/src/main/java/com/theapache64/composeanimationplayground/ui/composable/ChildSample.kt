package com.theapache64.composeanimationplayground.ui.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChildSample(
    title: String,
    content: @Composable () -> Unit
) {
    Text(text = title)
    Spacer(modifier = Modifier.height(4.dp))
    content()
}

