package uz.unzosoft.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.unzosoft.data.local.preference.Local
import uz.unzosoft.data.mapper.OnBoardingMapper
import uz.unzosoft.domain.datasource.OnBoardingDS
import uz.unzosoft.domain.utils.ext.executeLocalRequest
import javax.inject.Inject

/**
 * Created by Abdurashidov Shahzod on 07/06/22 17:58.
 * company QQBank
 * shahzod9933@gmail.com
 */
class OnBoardingImpl @Inject constructor(
    private var cache: Local,
    private var boardingMapper: OnBoardingMapper
) : OnBoardingDS {
    override suspend fun isOnBoarding(isBoarding: Boolean): Flow<Result<Boolean>> {
        return flow {
            cache.isOnBoarding = boardingMapper.mapTo(isBoarding)
        }
    }
}