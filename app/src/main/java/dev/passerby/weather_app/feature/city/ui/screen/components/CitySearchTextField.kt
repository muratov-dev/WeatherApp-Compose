package dev.passerby.weather_app.feature.city.ui.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.passerby.weather_app.R
import dev.passerby.weather_app.core.ui.theme.AppColors
import dev.passerby.weather_app.core.ui.theme.cornersShape
import dev.passerby.weather_app.feature.city.ui.event.CitySuggestionEvent
import dev.passerby.weather_app.feature.city.ui.state.CitySuggestionUiState
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay

@Composable
fun CitySearchTextField(
    state: CitySuggestionUiState,
    onEvent: (CitySuggestionEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    var fieldValue by remember { mutableStateOf("") }

    TextField(
        value = state.name ?: "",
        onValueChange = { text ->
            fieldValue = text
            state.name = fieldValue
        },
        maxLines = 1,
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
    LaunchedEffect(fieldValue) {
        state.name = fieldValue
        if (fieldValue.trim().length < 3) return@LaunchedEffect
        coroutineContext.cancelChildren()
        delay(300)
        onEvent(CitySuggestionEvent.OnCityNameInput(fieldValue.trim()))
    }
}