package dev.passerby.weather_app.feature.home.data.model

import dev.passerby.weather_app.feature.home.domain.model.DataModel
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val time: String, val values: Values
)

fun Data.toDomain() = DataModel(time = time, values = values.toDomain())
