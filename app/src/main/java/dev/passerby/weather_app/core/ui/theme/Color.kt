package dev.passerby.weather_app.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val textPrimary: Color = Color.Unspecified,
    val textSecondary: Color = Color.Unspecified,
    val textTertiary: Color = Color.Unspecified,

    val backgroundPrimary: Color = Color.Unspecified,
    val backgroundSecondary: Color = Color.Unspecified,

    val buttonPrimary: Color = Color.Unspecified,
    val buttonPrimaryHover: Color = Color.Unspecified,
    val buttonPrimaryDisabled: Color = Color.Unspecified,

    val buttonTextPrimary: Color = Color.Unspecified,
    val buttonTextPrimaryDisabled: Color = Color.Unspecified,

    val divider: Color = Color.Unspecified,
    val cityCard: Color = Color.Unspecified,
    val textField: Color = Color.Unspecified
) {

    companion object {
        @Stable
        val Light = AppColors(
            textPrimary = Color(0xFF1D1B20),
            textSecondary = Color(0xFFFFFFFF),
            textTertiary = Color(0xFF737373),

            backgroundPrimary = Color(0xFFFFFFFF),
            backgroundSecondary = Color(0xFFF9F9F9),

            buttonPrimary = Color(0xFF2E2F39),
            buttonPrimaryHover = Color(0xFF35363F),
            buttonPrimaryDisabled = Color(0xFFF9F9F9),

            buttonTextPrimary = Color(0xFFFFFFFF),
            buttonTextPrimaryDisabled = Color(0xFFC2C2C2),

            divider = Color(0x1A2E2F39),
            cityCard = Color(0xFFFFFFFF),
            textField = Color(0xFF2E2F39)
        )
    }
}