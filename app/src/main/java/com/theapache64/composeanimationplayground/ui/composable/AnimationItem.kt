package com.theapache64.composeanimationplayground.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.model.AnimationItem
import com.theapache64.composeanimationplayground.ui.theme.CodGray_700


@Composable
fun AnimationItem(
    index: Int,
    animationItem: AnimationItem,
    onClicked: (AnimationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    var isVisible by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.clickable {
            onClicked(animationItem)
        }
    ) {
        Column(
            Modifier
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = "${index + 1}) ${animationItem.title}")
                IconButton(
                    onClick = { isVisible = !isVisible },
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    val icon = if (isVisible) {
                        Icons.Outlined.PlayArrow
                    } else {
                        Icons.Default.PlayArrow
                    }
                    Icon(imageVector = icon, contentDescription = "Toggle")
                }
            }
            // Animation area
            animationItem.content(isVisible)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = animationItem.description, color = CodGray_700)
        }


        Divider()
    }
}
