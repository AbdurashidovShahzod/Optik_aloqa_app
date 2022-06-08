package uz.unzosoft.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.data.local.preference.Local
import uz.unzosoft.data.local.preference.LocalImpl


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCache(impl: LocalImpl): Local
}