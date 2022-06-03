package uz.unzosoft.domain.core

sealed class Failure {
    object ServerError : Failure()
    object ServerUnknownError : Failure()
    object UnauthorizedError : Failure()
    object UnknownLoginError : Failure()
    object ResponseIsNullError : Failure()
    object NetworkConnectionError : Failure()
    object TimeoutError : Failure()
    object SSLError : Failure()
    object UnknownError: Failure()
}