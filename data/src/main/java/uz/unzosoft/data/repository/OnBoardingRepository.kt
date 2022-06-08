package uz.unzosoft.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.unzosoft.data.di.MainDispatcher
import uz.unzosoft.domain.core.Result
import uz.unzosoft.domain.datasource.OnBoardingDS
import uz.unzosoft.domain.repository.OnBoardingRepository
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 07/06/22 18:02.
 * company QQBank
 * shahzod9933@gmail.com
 */

class OnBoardingRepositoryImpl @Inject constructor(
    @MainDispatcher private var dispatcher: CoroutineDispatcher,
    private var onBoardingDS: OnBoardingDS
) : OnBoardingRepository {
    override suspend fun getIsOnBoarding(isBoarding: Boolean): Flow<Result<Boolean>> =
        withContext(dispatcher) {
            return@withContext flow {
               onBoardingDS.isOnBoarding(isBoarding)
            }
        }
}