package dev.passerby.weather_app.feature.city.ui.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.passerby.weather_app.R
import dev.passerby.weather_app.core.ui.modifier.dropShadow
import dev.passerby.weather_app.core.ui.theme.AppColors
import dev.passerby.weather_app.core.ui.theme.cornersShape
import dev.passerby.weather_app.feature.city.domain.model.CityModel
import java.util.Locale

@Composable
fun CityListItemChecked(
    city: CityModel, onItemClick: (CityModel) -> Unit, modifier: Modifier = Modifier
) {
    val country = Locale("", city.country).displayCountry
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 4.dp)
            .dropShadow(shape = cornersShape, color = Color(0x403E3E3E), blur = 4.dp)
            .clip(shape = cornersShape)
            .background(color = AppColors.Light.cityCard)
    ) {
        Row(modifier = modifier
            .fillMaxWidth()
            .weight(1f)
            .clickable { onItemClick(city) }
            .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                text = "${city.name}, $country",
                style = TextStyle(
                    color = AppColors.Light.textPrimary,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.outfit_medium)),
                    lineHeight = 24.sp
                ),

            )
            Spacer(modifier = Modifier.size(8.dp))
            Icon(
                painter = painterResource(R.drawable.ic_check),
                contentDescription = null,
                tint = AppColors.Light.textPrimary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CityListItemCheckedPreview() {
    CityListItemChecked(CityModel("Russia", 1.0, 1.0, "Simferopol"), {})
}