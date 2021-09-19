package com.theapache64.composeanimationplayground.ui.screen.animation

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.R
import com.theapache64.composeanimationplayground.ui.composable.BigColumn

@Preview
@Composable
fun CrossfadeScreen() {
    BigColumn {
        var currentLogo by remember { mutableStateOf(R.drawable.ic_logo_compose) }
        Crossfade(
            targetState = currentLogo,
            animationSpec = tween(2000)
        ) { logo ->
            Image(
                painter = painterResource(id = logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
                    .clickable {
                        currentLogo = if (currentLogo == R.drawable.ic_logo_compose) {
                            R.drawable.ic_logo_tesla
                        } else {
                            R.drawable.ic_logo_compose
                        }
                    }
            )
        }

    }
}