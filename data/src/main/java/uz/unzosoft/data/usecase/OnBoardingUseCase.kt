package uz.unzosoft.data.usecase

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.domain.core.Result
import uz.unzosoft.domain.repository.OnBoardingRepository
import uz.unzosoft.domain.usecase.OnBoardingUseCase
import uz.unzosoft.domain.usecase.base.FlowUseCase
import javax.inject.Inject


/**
 * Created by Abdurashidov Shahzod on 07/06/22 18:02.
 * company QQBank
 * shahzod9933@gmail.com
 */
class OnBoardingUseCaseImpl @Inject constructor(
    private var repository: OnBoardingRepository
) : OnBoardingUseCase{
    override suspend fun invoke(params: Boolean): Flow<Result<Boolean>> {
        return repository.getIsOnBoarding(isBoarding = params)
    }

}