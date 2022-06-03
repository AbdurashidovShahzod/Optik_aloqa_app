package uz.unzosoft.domain.utils.ext

import uz.unzosoft.domain.core.Failure
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.net.ssl.SSLException

fun Exception.parseLocalError(): Failure {
    return when (this) {
        is UnknownHostException -> Failure.NetworkConnectionError
        is TimeoutException -> Failure.TimeoutError
        is SSLException -> Failure.SSLError
        else -> Failure.UnknownError
    }
}