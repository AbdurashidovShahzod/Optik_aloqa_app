package uz.unzosoft.domain.usecase.base

import kotlinx.coroutines.flow.Flow
import uz.unzosoft.domain.core.Result

interface SuspendUseCase<out T, in Params> {

    suspend operator fun invoke(params: Params): Flow<Result<T>>

}