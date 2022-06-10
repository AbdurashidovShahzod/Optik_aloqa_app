package uz.unzosoft.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.data.local.preference.Local
import uz.unzosoft.data.local.preference.LocalImpl
import uz.unzosoft.data.repository.OnBoardingRepositoryImpl
import uz.unzosoft.domain.repository.OnBoardingRepository


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCache(impl: LocalImpl): Local
    @Binds
    fun bindOnBoarding(impl:OnBoardingRepositoryImpl):OnBoardingRepository
}