package uz.unzosoft.optikaloqaapp.app.screen.onBoarding

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.unzosoft.data.usecase.OnBoardingUseCaseImpl
import uz.unzosoft.domain.core.Result
import uz.unzosoft.optikaloqaapp.app.base.BaseViewModel
import uz.unzosoft.optikaloqaapp.app.utils.utils.state.State
import javax.inject.Inject

@HiltViewModel
class OnBoardingScreenViewModel @Inject constructor(
    private var useCase: OnBoardingUseCaseImpl
) : BaseViewModel() {
    private val _launchState = MutableStateFlow<State<Boolean>>(State.Default)
    val launchState = _launchState.asStateFlow()

    fun isOnBoarding(isBoarding: Boolean) {
        _launchState.value = State.Loading
        viewModelScope.launch {
            useCase.invoke(params = isBoarding).collectLatest {
                when (it) {
                    is Result.Success -> _launchState.value = State.Success(it.data)
                    is Result.Error -> _launchState.value = State.Error(it.failure)
                }
            }
        }
    }
}