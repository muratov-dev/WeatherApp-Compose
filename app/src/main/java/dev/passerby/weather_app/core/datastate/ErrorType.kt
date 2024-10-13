package dev.passerby.weather_app.core.datastate

sealed interface ErrorType

data object ServerError : ErrorType
data object Connection : ErrorType
data object Unknown : ErrorType
