package uz.unzosoft.domain.usecase.base

interface SuspendUseCase<out T, in Params> {

    suspend operator fun invoke(params: Params): Result<T>

}