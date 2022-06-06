package uz.unzosoft.optikaloqaapp.app.screen.onBoarding.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.unzosoft.optikaloqaapp.app.screen.onBoarding.OnBoardPageScreen
import uz.unzosoft.optikaloqaapp.app.utils.utils.ext.putArgument


class OnBoardingPagerAdapter(
    private val image: List<Int>,
    private val title: List<String>,
    private val data: List<String>,
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {
    private var listenerNext: ((Int) -> Unit)? = null

    override fun getItemCount() = data.size

    override fun createFragment(position: Int): Fragment = OnBoardPageScreen()
        .apply {
            listenerNext?.let { this.setNext(it) }
        }.putArgument {
            putString("DATA", data[position])
            putString("TITLE", title[position])
            putInt("IMAGE", image[position])
        }

    fun setNext(block: (Int) -> Unit) {
        listenerNext = block
    }
}