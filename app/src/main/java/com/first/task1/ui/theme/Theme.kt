package com.first.counterapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF7043),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFFFAB91),
    onPrimaryContainer = Color(0xFFBF360C),
    secondary = Color(0xFFF06292),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFF8BBD0),
    onSecondaryContainer = Color(0xFF880E4F),
    tertiary = Color(0xFFFFD54F),
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFFFFF59D),
    onTertiaryContainer = Color(0xFF827717),
    background = Color(0xFFFFF8E1),
    onBackground = Color(0xFF1B1B1F),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1B1B1F),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE3E3E3),
    onSurfaceVariant = Color(0xFF414141),
    outline = Color(0xFF7D7D7D),
    outlineVariant = Color(0xFFBDBDBD),
    inverseSurface = Color(0xFFE6E1E5),
    inverseOnSurface = Color(0xFF1C1B1F),
    inversePrimary = Color(0xFFFF7043)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFAB91),
    onPrimary = Color(0xFFBF360C),
    primaryContainer = Color(0xFFBF360C),
    onPrimaryContainer = Color(0xFFFFAB91),
    secondary = Color(0xFFF8BBD0),
    onSecondary = Color(0xFF880E4F),
    secondaryContainer = Color(0xFF880E4F),
    onSecondaryContainer = Color(0xFFF8BBD0),
    tertiary = Color(0xFFFFF59D),
    onTertiary = Color(0xFF827717),
    tertiaryContainer = Color(0xFF827717),
    onTertiaryContainer = Color(0xFFFFF59D),
    background = Color(0xFF1B1B1F),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1B1B1F),
    onSurface = Color(0xFFE6E1E5),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    surfaceVariant = Color(0xFF49454F),
    onSurfaceVariant = Color(0xFFCAC4D0),
    outline = Color(0xFF938F99),
    outlineVariant = Color(0xFF49454F),
    inverseSurface = Color(0xFFE6E1E5),
    inverseOnSurface = Color(0xFF1C1B1F),
    inversePrimary = Color(0xFFFF7043)
)

/* Other default colors to override
background = Color(0xFFFFFBFE),
surface = Color(0xFFFFFBFE),
onPrimary = Color.White,
onSecondary = Color.White,
onTertiary = Color.White,
onBackground = Color(0xFF1C1B1F),
onSurface = Color(0xFF1C1B1F),
*/


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
    val AppTypography = Typography()

@Composable
fun CounterAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
