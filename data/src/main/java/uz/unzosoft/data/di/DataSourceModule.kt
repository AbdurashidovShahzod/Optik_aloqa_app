package uz.unzosoft.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
interface DataSourceModule {

//    @Binds
//    fun bindsDataSource(source: DataSourceImp): DataSource

}