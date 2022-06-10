package uz.unzosoft.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.data.datasource.OnBoardingImpl
import uz.unzosoft.domain.datasource.OnBoardingDS
@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsDataSource(source: OnBoardingImpl): OnBoardingDS

}