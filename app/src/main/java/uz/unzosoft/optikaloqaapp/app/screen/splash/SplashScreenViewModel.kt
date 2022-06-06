package uz.unzosoft.optikaloqaapp.app.screen.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import uz.unzosoft.optikaloqaapp.app.base.BaseViewModel
import uz.unzosoft.optikaloqaapp.app.utils.utils.state.State
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : BaseViewModel() {
    private val _navigateState = MutableStateFlow(State.Default)
    val navigateState = _navigateState.asStateFlow()

    init {
        launchVM {
            delay(3000L)
            _navigateState.emit(State.Default)
        }
    }
}