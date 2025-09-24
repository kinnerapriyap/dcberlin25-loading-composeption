package com.kinnerapriyap.loading_composeption.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFF6B8E79),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD9E6DC),
    onPrimaryContainer = Color(0xFF0F261B),

    secondary = Color(0xFFE07A5F),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFF3C8BC),
    onSecondaryContainer = Color(0xFF3A120C),

    tertiary = Color(0xFF2F7A73),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFBEE5E1),
    onTertiaryContainer = Color(0xFF072624),

    surface = Color(0xFFFCFEFC),
    onSurface = Color(0xFF1B1D1B),
    surfaceVariant = Color(0xFFE3E7E4),
    onSurfaceVariant = Color(0xFF444A46),

    outline = Color(0xFF737A75),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8BC34A),
    secondary = Color(0xFF607D8B),
    onPrimary = Color(0xFF212121),
    onSecondary = Color(0xFF757575),
    tertiary = Color(0xFF212121),
    onTertiary = Color(0xFF757575),
)

@Composable
fun DemoTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val droidconBerlinFontFamily = FontFamily(
        Font("font/JosefinSans-Regular.ttf", FontWeight.Normal),
        Font("font/JosefinSans-SemiBold.ttf", FontWeight.SemiBold),
        Font("font/JosefinSans-Bold.ttf", FontWeight.Bold),
        Font("font/JosefinSans-Medium.ttf", FontWeight.Medium),
        Font("font/JosefinSans-Light.ttf", FontWeight.Light),
        Font("font/JosefinSans-Thin.ttf", FontWeight.Thin),
    )
    val colors: ColorScheme = if (darkTheme) DarkColors else LightColors
    val typography = Typography(
        displayLarge = TextStyle(
            fontSize = 54.sp,
            lineHeight = 60.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = droidconBerlinFontFamily
        ),
        headlineLarge = TextStyle(
            fontSize = 36.sp,
            lineHeight = 42.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = droidconBerlinFontFamily
        ),
        headlineMedium = TextStyle(
            fontSize = 28.sp,
            lineHeight = 34.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = droidconBerlinFontFamily
        ),
        titleLarge = TextStyle(
            fontSize = 22.sp,
            lineHeight = 28.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = droidconBerlinFontFamily
        ),
        titleMedium = TextStyle(
            fontSize = 18.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = droidconBerlinFontFamily
        ),
        bodyLarge = TextStyle(fontSize = 16.sp, lineHeight = 22.sp, fontFamily = droidconBerlinFontFamily),
        bodyMedium = TextStyle(fontSize = 14.sp, lineHeight = 20.sp, fontFamily = droidconBerlinFontFamily)
    )
    val shapes = Shapes(
        extraSmall = RoundedCornerShape(8.dp),
        small = RoundedCornerShape(12.dp),
        medium = RoundedCornerShape(16.dp),
        large = RoundedCornerShape(24.dp),
        extraLarge = RoundedCornerShape(32.dp)
    )
    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

