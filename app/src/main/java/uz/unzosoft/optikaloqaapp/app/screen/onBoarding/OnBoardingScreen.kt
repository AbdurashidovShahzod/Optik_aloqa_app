package uz.unzosoft.optikaloqaapp.app.screen.onBoarding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.unzosoft.optikaloqaapp.R
import uz.unzosoft.optikaloqaapp.app.base.BaseScreen
import uz.unzosoft.optikaloqaapp.app.screen.onBoarding.adapter.OnBoardingPagerAdapter
import uz.unzosoft.optikaloqaapp.databinding.ScreenOnBoardingBinding
import uz.unzosoft.optikaloqaapp.databinding.ScreenSplashBinding

@AndroidEntryPoint
class OnBoardingScreen : BaseScreen(R.layout.screen_on_boarding) {
    override val viewModel: OnBoardingScreenViewModel by viewModels()
    private lateinit var adapter: OnBoardingPagerAdapter
    private val image = arrayListOf(R.drawable.mudofa, R.drawable.okrugr, R.drawable.mudofa)
    private val title = arrayListOf(
        "O`zbekiston Respublikasi Mudofaa vazirligi",
        "O`zbekiston Respublikasi Mudofaa vazirligi",
        "O`zbekiston Respublikasi Mudofaa vazirligi"
    )
    private val data =
        arrayListOf(
            "Ilovada mudofaa vazirligi haqida barcha yangliklar",
            "Okruglar haqida malumot",
            "Mudofaa vazirligiga oid multimedialar bilan tanishasiz"
        )
    private val binding by viewBinding(ScreenOnBoardingBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

    }
}