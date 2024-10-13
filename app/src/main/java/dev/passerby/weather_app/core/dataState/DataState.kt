package dev.passerby.weather_app.core.dataState

sealed class DataState<out T> {
    class Loading<T> : DataState<T>()
    class Success<out T>(val data: T) : DataState<T>()
    class Error<T>(val type: ErrorType = Unknown) : DataState<T>()

    val isSuccess: Boolean
        get() = this is Success

    val isError: Boolean
        get() = this is Error

    val isLoading: Boolean
        get() = this is Loading

    inline fun on(
        loading: () -> Unit = {},
        success: (T) -> Unit = {},
        error: (ErrorType) -> Unit = {},
    ) {
        when (this) {
            is Success -> success(data)
            is Loading -> loading()
            is Error -> error(type)
        }
    }
}