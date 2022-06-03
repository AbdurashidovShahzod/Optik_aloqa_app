package uz.unzosoft.optikaloqaapp.app.utils.utils.state

import uz.unzosoft.domain.core.Failure

sealed class State<out T> {
    object Default : State<Nothing>()
    object Loading : State<Nothing>()
    class Error(val failure: Failure) : State<Nothing>()
    class Success<out T>(val data: T) : State<T>()
}
