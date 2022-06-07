package uz.unzosoft.domain.datasource

import kotlinx.coroutines.flow.Flow


/**
 * Created by Abdurashidov Shahzod on 07/06/22 17:58.
 * company QQBank
 * shahzod9933@gmail.com
 */
interface OnBoarding {
    suspend fun isOnBoarding(isBoarding: Boolean): Flow<Boolean>
}