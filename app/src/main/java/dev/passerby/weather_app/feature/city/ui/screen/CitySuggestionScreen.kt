package dev.passerby.weather_app.feature.city.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.passerby.weather_app.R
import dev.passerby.weather_app.core.ui.theme.AppColors
import dev.passerby.weather_app.core.ui.theme.cornersShape
import dev.passerby.weather_app.feature.city.domain.model.CityModel
import dev.passerby.weather_app.feature.city.ui.screen.components.CityListItemChecked
import dev.passerby.weather_app.feature.city.ui.screen.components.CityListItemUnchecked
import dev.passerby.weather_app.feature.city.ui.screen.components.CitySearchTextField
import dev.passerby.weather_app.feature.city.ui.viewmodel.CitySuggestionViewModel

@Composable
fun CitySuggestionScreen(
    viewModel: CitySuggestionViewModel = hiltViewModel()
) {

}

@Composable
fun CitySuggestionContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(color = AppColors.Light.backgroundPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(24.dp))
        CitySearchTextField(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.size(16.dp))
        Box(modifier = Modifier.weight(1f)){
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 16.dp)
                    .background(color = AppColors.Light.backgroundSecondary, shape = cornersShape)
                    .clip(cornersShape)
            ) {
                CityListItemUnchecked(CityModel("Russia", 1.0, 1.0, "Simferopol"), {})
                CityListItemUnchecked(CityModel("Russia", 1.0, 1.0, "Simferopol"), {})
                CityListItemChecked(CityModel("Russia", 1.0, 1.0, "Simferopol"), {})
                CityListItemUnchecked(CityModel("Russia", 1.0, 1.0, "Simferopol"), {})
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {},
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
        ) { Text(text = "Confirm", style = TextStyle(
            fontFamily = FontFamily(Font(R.font.outfit_bold)),
            lineHeight = 24.sp,
            fontSize = 16.sp
        )
        ) }
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun CitySuggestionScreenPreview() {
    Box {
        CitySuggestionContent()
    }
}