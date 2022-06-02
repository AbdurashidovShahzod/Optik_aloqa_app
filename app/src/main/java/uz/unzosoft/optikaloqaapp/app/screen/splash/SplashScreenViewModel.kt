package uz.unzosoft.optikaloqaapp.app.screen.splash

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import uz.unzosoft.optikaloqaapp.app.base.BaseVM

class SplashScreenViewModel : BaseVM() {
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        launchVM {
            repeat(10000000) {
                _sharedFlow.emit(it)
                delay(1000L)
            }
        }
    }
}