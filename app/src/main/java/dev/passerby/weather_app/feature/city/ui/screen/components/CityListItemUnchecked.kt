package dev.passerby.weather_app.feature.city.ui.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
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
import dev.passerby.weather_app.R
import dev.passerby.weather_app.core.ui.theme.AppColors
import dev.passerby.weather_app.core.ui.theme.cornersShape
import dev.passerby.weather_app.feature.city.domain.model.CityModel
import java.util.Locale

@Composable
fun CityListItemUnchecked(
    city: CityModel, onItemClick: (CityModel) -> Unit, modifier: Modifier = Modifier
) {
    val country = Locale("", city.country).displayCountry
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp)
            .clip(cornersShape)
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .weight(1f)
            .clickable { onItemClick(city) }) {
            Text(
                modifier = modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "${city.name}, $country",
                style = TextStyle(
                    color = AppColors.Light.textPrimary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_medium)),
                    lineHeight = 24.sp
                ),
                maxLines = 1
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = AppColors.Light.divider,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun CityListItemUncheckedPreview() {
    CityListItemUnchecked(CityModel("Russia", 1.0, 1.0, "Simferopol"), {})
}