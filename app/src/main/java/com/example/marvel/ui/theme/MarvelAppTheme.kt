package com.example.marvel.ui.theme;

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp


object MarvelAppTheme {
    object BgColors {
        val primary = BackgroundBlack
        val divider = Color(0xFF1A1F29)
        val border = Color(0xFF1F2430)
        val chip = Color(0x3D44A9F4)
    }

    object ButtonColors {
        val primary = Color(0xfff4d144)
        val blur = Color(0x38F4D144)
    }

    object TextColors {
        val white = Color(0xFFEEF2FB)
        val gray = Color(0xb2eef2fb)
        val comment = Color(0xFFA8ADB7)
        val date = Color(0x66FFFFFF)
        val chip = Color(0xFF44A9F4)
        val downloads = Color(0xFF45454D)
    }

    object TextStyle {

        val Bold_Character_Name
            @Composable get() = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false),
                lineHeightStyle = LineHeightStyle(
                    LineHeightStyle.Alignment.Proportional, LineHeightStyle.Trim.None
                ),
                color = PrimaryText
            )

        val Bold_Character_Phrase
            @Composable get() = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false),
                lineHeightStyle = LineHeightStyle(
                    LineHeightStyle.Alignment.Proportional, LineHeightStyle.Trim.None
                ),
                color = PrimaryText
            )

        val Bold_48
            @Composable get() = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 44.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false),
                lineHeightStyle = LineHeightStyle(
                    LineHeightStyle.Alignment.Proportional, LineHeightStyle.Trim.None
                ),
                color = PrimaryText
            )
    }
}
