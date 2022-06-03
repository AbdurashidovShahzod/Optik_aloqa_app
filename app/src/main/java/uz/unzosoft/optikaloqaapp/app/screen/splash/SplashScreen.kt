package uz.unzosoft.optikaloqaapp.app.screen.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.unzosoft.optikaloqaapp.R
import uz.unzosoft.optikaloqaapp.app.base.BaseScreen
import uz.unzosoft.optikaloqaapp.app.utils.utils.ext.toast
import uz.unzosoft.optikaloqaapp.app.utils.utils.state.State
import uz.unzosoft.optikaloqaapp.databinding.ScreenSplashBinding

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : BaseScreen(R.layout.screen_splash) {
    override val viewModel: SplashScreenViewModel by viewModels()
    private val binding by viewBinding(ScreenSplashBinding::bind)

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeStates()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.navigateState.collect {
                    Toast.makeText(requireContext(), "Splash screen!!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun observeStates() {
        lifecycleScope.launch{
            viewModel.navigateState.flowWithLifecycle(lifecycle,Lifecycle.State.STARTED).collect{ state ->
                when(state){
                    is State.Default ->{toast("Splash screen")} else -> Unit
                }
            }
        }
    }
}