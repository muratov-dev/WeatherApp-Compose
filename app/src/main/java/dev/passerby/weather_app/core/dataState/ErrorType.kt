package dev.passerby.weather_app.core.dataState

sealed interface ErrorType

data object ServerError : ErrorType
data object Connection : ErrorType
data object Unknown : ErrorType
