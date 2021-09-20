package com.theapache64.composeanimationplayground.ui.screen.animation.animatedcontent

import androidx.compose.animation.*
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.ui.composable.ComposeLogo
import com.theapache64.composeanimationplayground.ui.composable.TeslaLogo
import com.theapache64.composeanimationplayground.ui.theme.CodGray_700

@Preview
@Composable
fun SizeTransformScreen() {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Surface(
            color = CodGray_700,
            onClick = { expanded = !expanded }
        ) {
            AnimatedContent(
                targetState = expanded,
                transitionSpec = {
                    fadeIn() with fadeOut() using
                            SizeTransform(clip = false) { initialSize, targetSize ->
                                if (targetState) {
                                    // Expand animation
                                    keyframes {
                                        // Expand horizontally first.
                                        IntSize(targetSize.width, targetSize.height) at 2000 // 0 to 2000

                                        /**
                                         * Here the total duration is 3s.
                                         * Above one will take 2s, so the remaining 1s will be used to expand vertically
                                         */
                                        durationMillis = 3000
                                    }
                                } else {
                                    // Shrink animation
                                    keyframes {
                                        // Shrink vertically first.
                                        IntSize(targetSize.width, targetSize.height) at 2000 // 0 to 2000

                                        /**
                                         * Here the total duration is 3s.
                                         * Above one will take 2s, so the remaining 1s will be used to shrink horizontally
                                         */
                                        durationMillis = 3000
                                    }
                                }
                            }
                }
            ) { targetExpanded ->
                if (targetExpanded) {
                    TeslaLogo(
                        modifier = Modifier
                            .size(300.dp)
                    )
                } else {
                    ComposeLogo(
                        modifier = Modifier
                            .size(50.dp)
                    )
                }
            }
        }
    }
}