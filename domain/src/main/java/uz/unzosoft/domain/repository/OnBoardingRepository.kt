package uz.unzosoft.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.domain.core.Result


/**
 * Created by Abdurashidov Shahzod on 07/06/22 18:02.
 * company QQBank
 * shahzod9933@gmail.com
 */
interface OnBoardingRepository {
    suspend fun getIsOnBoarding(isBoarding: Boolean):Flow<Result<Boolean>>
}