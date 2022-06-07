package uz.unzosoft.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppCacheQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EncryptedCacheQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OrzonServiceQualifier
