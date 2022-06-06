package uz.unzosoft.optikaloqaapp.app.screen.onBoarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.unzosoft.optikaloqaapp.R
import uz.unzosoft.optikaloqaapp.databinding.OnboardingPageBinding


class OnBoardPageScreen : Fragment(R.layout.onboarding_page) {
    private lateinit var binding: OnboardingPageBinding
    private var listenerNext: ((Int) -> Unit)? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        binding = OnboardingPageBinding.bind(view)
        val bundle = requireArguments()
        val data = bundle.getString("DATA", "")
        val title = bundle.getString("TITLE", "")
        val image = bundle.getInt("IMAGE", 0)
        binding.image.setImageResource(image)
        binding.title.text = title
        binding.data.text = data
        next.setOnClickListener {
            listenerNext?.invoke(image)
        }

    }

    fun setNext(block: (Int) -> Unit) {
        listenerNext = block
    }

}