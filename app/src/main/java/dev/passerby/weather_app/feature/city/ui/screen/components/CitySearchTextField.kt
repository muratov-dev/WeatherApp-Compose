package dev.passerby.weather_app.feature.city.ui.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.passerby.weather_app.R
import dev.passerby.weather_app.core.ui.theme.AppColors
import dev.passerby.weather_app.core.ui.theme.cornersShape

@Composable
fun CitySearchTextField(modifier: Modifier = Modifier) {
    val fieldValue = remember { mutableStateOf("") }
    TextField(
        value = fieldValue.value,
        onValueChange = { text -> fieldValue.value = text },
        placeholder = {
            Text(
                text = "City name", style = TextStyle(
                    color = Color(0xFF737373), fontFamily = FontFamily(Font(R.font.outfit_regular))
                )
            )
        },
        shape = cornersShape,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = AppColors.Light.textField,
            unfocusedContainerColor = AppColors.Light.textField,
            focusedTextColor = AppColors.Light.textSecondary,
            unfocusedTextColor = AppColors.Light.textSecondary,
            cursorColor = AppColors.Light.textSecondary
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.outfit_medium)),
            lineHeight = 20.sp,
            fontSize = 16.sp
        ),

        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(cornersShape)
    )
}

@Preview
@Composable
private fun CitySearchTextFieldPreview() {
    CitySearchTextField()
}