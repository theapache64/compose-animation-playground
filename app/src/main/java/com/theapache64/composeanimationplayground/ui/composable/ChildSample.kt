package com.theapache64.composeanimationplayground.ui.composable

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.ChildSample(
    title: String,
    content: @Composable () -> Unit
) {
    Text(text = title)
    Spacer(modifier = Modifier.height(10.dp))
    content()
    Spacer(modifier = Modifier.height(20.dp))
}

