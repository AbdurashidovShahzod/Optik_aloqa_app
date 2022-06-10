package uz.unzosoft.optikaloqaapp.app.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.unzosoft.optikaloqaapp.R
import uz.unzosoft.optikaloqaapp.app.base.BaseScreen
import uz.unzosoft.optikaloqaapp.app.utils.utils.ext.toast
import uz.unzosoft.optikaloqaapp.databinding.ScreenSplashBinding

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : BaseScreen(R.layout.screen_splash) {
    override val viewModel: SplashScreenViewModel by viewModels()
    private val binding by viewBinding(ScreenSplashBinding::bind)

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeStates()
        loadAnimationData()
    }

    private fun loadAnimationData() = with(binding) {
        imgSplash.animation = AnimationUtils.loadAnimation(requireContext(),R.anim.side_anim)
        tvSplash.animation = AnimationUtils.loadAnimation(requireContext(),R.anim.bottom_anim)
    }

    private fun observeStates() {
        lifecycleScope.launch {
            viewModel.navigateState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest { isBoarding ->
                    navigate(isBoarding)
                }
        }
    }
    suspend fun navigate(isBoarding:Boolean){
        delay(3000)
        if (isBoarding){
            toast(true)
        }else findNavController().navigate(R.id.action_splashScreen_to_onBoardingScreen)
    }
}