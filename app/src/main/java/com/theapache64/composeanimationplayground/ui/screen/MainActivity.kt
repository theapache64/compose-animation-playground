package com.theapache64.composeanimationplayground.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.theapache64.composeanimationplayground.ui.screen.animation.animatedvisibility.ChildBasedAnimationDemo
import com.theapache64.composeanimationplayground.ui.theme.ComposeAndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidTemplateTheme {
                Surface {
                    // AppNavigation()
                    ChildBasedAnimationDemo()
                }
            }
        }
    }
}
