package dev.passerby.weather_app.feature.city.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.passerby.weather_app.R
import dev.passerby.weather_app.core.ui.theme.AppColors
import dev.passerby.weather_app.core.ui.theme.cornersShape
import dev.passerby.weather_app.feature.city.ui.event.CitySuggestionEvent
import dev.passerby.weather_app.feature.city.ui.screen.components.CityListItemChecked
import dev.passerby.weather_app.feature.city.ui.screen.components.CityListItemUnchecked
import dev.passerby.weather_app.feature.city.ui.screen.components.CitySearchTextField
import dev.passerby.weather_app.feature.city.ui.state.CitySuggestionUiState
import dev.passerby.weather_app.feature.city.ui.viewmodel.CitySuggestionViewModel

@Composable
fun CitySuggestionScreen(
    viewModel: CitySuggestionViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    CitySuggestionContent(state, viewModel::onEvent)
}

@Composable
fun CitySuggestionContent(
    state: CitySuggestionUiState, onEvent: (CitySuggestionEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .imePadding()
            .fillMaxSize()
            .systemBarsPadding()
            .background(color = AppColors.Light.backgroundPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(24.dp))
        CitySearchTextField(state, onEvent, modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.size(16.dp))
        if (state.citySuggestionList.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .clip(cornersShape)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .wrapContentHeight()
                        .background(color = AppColors.Light.backgroundSecondary, shape = cornersShape)
                        .clip(cornersShape)
                        .padding(vertical = 4.dp)
                ) {
                    state.citySuggestionList.forEach { city ->
                        if (city.isChecked) {
                            CityListItemChecked(city = city,
                                onItemClick = { onEvent(CitySuggestionEvent.OnCityClick(city)) })
                        } else {
                            CityListItemUnchecked(city = city,
                                onItemClick = { onEvent(CitySuggestionEvent.OnCityClick(city)) })
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }
        Button(
            onClick = { onEvent(CitySuggestionEvent.OnCityConfirmClick) },
            enabled = state.confirmButtonIsEnabled,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clip(cornersShape),
            shape = cornersShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.Light.buttonPrimary,
                contentColor = AppColors.Light.buttonTextPrimary,
                disabledContainerColor = AppColors.Light.buttonPrimaryDisabled,
                disabledContentColor = AppColors.Light.buttonTextPrimaryDisabled
            )
        ) {
            Text(
                text = "Confirm", style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.outfit_bold)),
                    lineHeight = 24.sp,
                    fontSize = 16.sp
                )
            )
        }
        Spacer(modifier = Modifier.size(24.dp))
    }
}