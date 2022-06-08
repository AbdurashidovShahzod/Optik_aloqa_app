package uz.unzosoft.data.mapper

import uz.unzosoft.domain.core.Mapper
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 08/06/22 18:46.
 * company QQBank
 * shahzod9933@gmail.com
 */
class OnBoardingMapper @Inject constructor() :Mapper<Boolean,Boolean> {
    override fun mapFrom(from: Boolean): Boolean {
        return from
    }

    override fun mapTo(from: Boolean): Boolean {
       return from
    }
}