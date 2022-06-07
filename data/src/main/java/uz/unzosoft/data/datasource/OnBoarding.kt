package uz.unzosoft.data.datasource

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.data.local.preference.Local
import uz.unzosoft.data.local.preference.LocalImpl
import uz.unzosoft.domain.datasource.OnBoarding
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 07/06/22 17:58.
 * company QQBank
 * shahzod9933@gmail.com
 */
class OnBoardingImpl @Inject constructor(
    var cache:Local
) :OnBoarding {
    override suspend fun isOnBoarding(isBoarding: Boolean): Flow<Boolean> {

    }

}