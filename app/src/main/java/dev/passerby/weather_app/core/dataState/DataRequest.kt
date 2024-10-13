package dev.passerby.weather_app.core.dataState

import dev.passerby.weather_app.core.network.exception.NoConnectivityException
import retrofit2.HttpException
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException

inline fun <T> dataRequest(block: () -> T): DataState<T> {
    return try {
        val result = block()
        Timber.i("data request SUCCESSFUL, data = $result")
        DataState.Success(result)
    } catch (e: NoConnectivityException) {
        Timber.tag("data request EXCEPTION").e("data request FAILED, cause = NO INTERNET CONNECTION")
        DataState.Error(type = Connection)
    } catch (e: SocketTimeoutException) {
        Timber.tag("data request EXCEPTION").e("data request FAILED,cause = SOCKET TIMEOUT, e = $e")
        DataState.Error(type = Connection)
    } catch (e: ConnectException) {
        Timber.tag("data request EXCEPTION").e("data request FAILED,cause = CONNECT, e = $e")
        DataState.Error(type = Connection)
    } catch (e: HttpException) {
        when (e.code()) {
            400 -> {
                Timber.tag("data request EXCEPTION").e("data request FAILED,cause = SERVER_ERROR, e = $e")
                DataState.Error(type = ServerError)
            }

            else -> {
                Timber.tag("data request EXCEPTION").e("data request FAILED, cause = UNKNOWN, e = $e}")
                DataState.Error(type = Unknown)
            }
        }
    } catch (e: Exception) {
        Timber.tag("data request EXCEPTION").e(t = e, message = "data request FAILED,cause = UNKNOWN, e = $e")
        DataState.Error(type = Unknown)
    }
}