package uz.unzosoft.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    //@Binds
    //fun bindsActiveOrdersListUseCase(case: ActiveOrdersListUseCaseImp): ActiveOrdersListUseCase

}