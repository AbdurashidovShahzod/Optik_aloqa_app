package uz.unzosoft.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.data.usecase.OnBoardingUseCaseImpl
import uz.unzosoft.domain.usecase.OnBoardingUseCase


@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindsOnBoardingUseCase(case: OnBoardingUseCaseImpl): OnBoardingUseCase

}