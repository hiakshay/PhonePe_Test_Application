package com.akshay.phonepetestapplication.di

import com.akshay.phonepetestapplication.network.api.MoviesContentAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object ApiModule {

    @Provides
    fun providesTrueCallerContentApi(
        retrofit: Retrofit
    ): MoviesContentAPI {
        return retrofit.create(MoviesContentAPI::class.java)
    }

}