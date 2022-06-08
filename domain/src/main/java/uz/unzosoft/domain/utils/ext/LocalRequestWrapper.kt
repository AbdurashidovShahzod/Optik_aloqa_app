package uz.unzosoft.domain.utils.ext

import uz.unzosoft.domain.core.Failure
import uz.unzosoft.domain.core.Result
import java.lang.Exception

suspend fun <T : Any> executeLocalRequest(request: suspend () -> T?): Result<T> {
    return try {
        val response = request()
        if (response != null)
            Result.Success(response)
        else Result.Error(Failure.ResponseIsNullError)
    } catch (e: Exception) {
        Result.Error(e.parseLocalError())
    }
}