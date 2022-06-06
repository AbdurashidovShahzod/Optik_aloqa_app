package uz.unzosoft.optikaloqaapp.app.utils.utils.ext

import android.os.Bundle
import androidx.fragment.app.Fragment


/**
 * Created by Mahmudova Dilnoza on 9/14/2021.
 * QQB
 * icebear03051999@gmail.com
 */
 fun Fragment.putArgument(block: Bundle.()->Unit):Fragment{
    val bundle=arguments?: Bundle()
    block(bundle)
    arguments=bundle
    return this
}