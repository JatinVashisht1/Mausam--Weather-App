package com.example.mausamweatherapp.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blue759,
    primaryVariant = Yellow479,
    secondary = Yellow479,
    //  Other default colors to override
    background = Yellow705,
    surface = Blue759,
    onPrimary = YellowLight,
    onSecondary = Blue759,
    onBackground = Blue759,
    onSurface = Blue759,
)

private val LightColorPalette = lightColors(
    primary = Blue759,
    primaryVariant = Yellow479,
    secondary = Yellow479,
    //  Other default colors to override
    background = Yellow705,
    surface = Blue759,
    onPrimary = YellowLight,
    onSecondary = Blue759,
    onBackground = Blue759,
    onSurface = Blue759,

)

@Composable
fun MausamWeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}