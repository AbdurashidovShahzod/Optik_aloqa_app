package uz.unzosoft.data.di

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.data.di.AppCacheQualifier
import uz.unzosoft.data.local.preference.Local
import uz.unzosoft.data.local.preference.LocalImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    @AppCacheQualifier
    fun provideAppCacheSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences {
        try {
            val mainKey = MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
            return EncryptedSharedPreferences.create(
                context,
                "APP_CACHE",
                mainKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return context.getSharedPreferences("APP_CACHE", Context.MODE_PRIVATE)
    }

}