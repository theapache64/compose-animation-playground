package com.theapache64.composeanimationplayground.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.theapache64.composeanimationplayground.R

val GoogleSans = FontFamily(
    Font(R.font.google_sans_regular, FontWeight.Normal),
    Font(R.font.google_sans_medium, FontWeight.Medium),
    Font(R.font.google_sans_bold, FontWeight.Bold),
)

val Typography = Typography(

    defaultFontFamily = GoogleSans,

    h1 = TextStyle(
        fontSize = 95.sp,
        fontWeight = FontWeight.Normal,
    ),
    h2 = TextStyle(
        fontSize = 59.sp,
        fontWeight = FontWeight.Normal,
    ),
    h3 = TextStyle(
        fontSize = 48.sp,
        fontWeight = FontWeight.Medium
    ),
    h4 = TextStyle(
        fontSize = 34.sp,
        fontWeight = FontWeight.Medium,
    ),
    h5 = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium
    ),
    h6 = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    ),
    subtitle1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
    ),
    subtitle2 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    ),
    body1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
    ),
    body2 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
    ),
    overline = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
    )
)


