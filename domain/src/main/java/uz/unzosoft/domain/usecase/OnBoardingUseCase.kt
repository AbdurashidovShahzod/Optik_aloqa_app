package uz.unzosoft.domain.usecase

import uz.unzosoft.domain.usecase.base.SuspendUseCase


/**
 * Created by Abdurashidov Shahzod on 07/06/22 18:02.
 * company QQBank
 * shahzod9933@gmail.com
 */
interface OnBoardingUseCase:SuspendUseCase<Boolean,Boolean> {
    override suspend fun invoke(params: Boolean): Result<Boolean> {
        return Result.success(params)
    }
}