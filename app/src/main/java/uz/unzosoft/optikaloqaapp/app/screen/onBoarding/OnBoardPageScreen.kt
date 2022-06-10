package uz.unzosoft.optikaloqaapp.app.screen.onBoarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.unzosoft.optikaloqaapp.R
import uz.unzosoft.optikaloqaapp.app.base.BaseScreen
import uz.unzosoft.optikaloqaapp.app.base.BaseViewModel
import uz.unzosoft.optikaloqaapp.databinding.OnboardingPageBinding
import uz.unzosoft.optikaloqaapp.databinding.ScreenOnBoardingBinding


class OnBoardPageScreen : BaseScreen(R.layout.onboarding_page) {
    private val binding by viewBinding(OnboardingPageBinding::bind)
    private var listenerNext: ((Int) -> Unit)? = null
    override val viewModel:OnBoardPageScreenVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onViewCreated(view, savedInstanceState)
        val bundle = requireArguments()
        val data = bundle.getString("DATA", "")
        val title = bundle.getString("TITLE", "")
        val image = bundle.getInt("IMAGE", 0)
        binding.image.setImageResource(image)
        binding.title.text = title
        binding.data.text = data
        binding.next.setOnClickListener {
            listenerNext?.invoke(image)
        }

    }

    fun setNext(block: (Int) -> Unit) {
        listenerNext = block
    }

}