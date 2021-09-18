package com.theapache64.composeanimationplayground.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.theapache64.composeanimationplayground.R

@Composable
fun TeslaLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_logo_tesla),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
    )

    /*Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(Color.Red)
    )*/
}