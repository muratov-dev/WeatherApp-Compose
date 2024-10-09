package dev.passerby.weather_app.home.data.model

import dev.passerby.weather_app.home.domain.model.DataModel
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val time: String, val values: Values
)

fun Data.toDomain() = DataModel(time = time, values = values.toDomain())
