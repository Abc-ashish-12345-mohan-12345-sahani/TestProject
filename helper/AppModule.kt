package com.example.mytestapplication.helper

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context) = context

    @Singleton
    @Provides
    fun providesNetworkInterceptor(@ApplicationContext context: Context) =
            NetworkConnectionInterceptor(context)

    @Singleton
    @Provides
     fun providesMainRepository(networkConnectionInterceptor: NetworkConnectionInterceptor) =
         AuthRepository(networkConnectionInterceptor)
}