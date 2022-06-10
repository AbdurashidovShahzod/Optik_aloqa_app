package uz.unzosoft.optikaloqaapp.app.screen.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import uz.unzosoft.data.local.preference.Local
import uz.unzosoft.optikaloqaapp.app.base.BaseViewModel
import uz.unzosoft.optikaloqaapp.app.utils.utils.state.State
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val cache:Local
) : BaseViewModel() {
    private val _navigateState = MutableStateFlow<Boolean>(false)
    val navigateState = _navigateState.asStateFlow()

    init {
        launchVM {
            _navigateState.value = cache.isOnBoarding
        }
    }
}