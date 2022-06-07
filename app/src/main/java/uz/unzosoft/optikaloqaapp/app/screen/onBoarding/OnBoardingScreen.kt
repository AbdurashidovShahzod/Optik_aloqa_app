package uz.unzosoft.optikaloqaapp.app.screen.onBoarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = OnBoardingPagerAdapter(image, title, data, requireActivity())
        binding.pager.adapter = adapter


        binding.skip.setOnClickListener {
            checkOnBoarding()
        }
        binding.apply {
            adapter.setNext {
                if (pager.currentItem < image.size - 1) {
                    pager.currentItem = pager.currentItem + 1
                } else if (pager.currentItem == image.size - 1) {
                    checkOnBoarding()
                }
            }
            TabLayoutMediator(tabLay, pager) { t, p ->

            }.attach()
            tabLay.selectedTabPosition
        }


    }
    private fun checkOnBoarding() {
        if (!localStorage.isOnBoarding) {
            localStorage.isOnBoarding = true
            val intent = Intent(context, HomeActivity2::class.java)
            startActivity(intent)
            activity?.finishAffinity()
        }
    }
}