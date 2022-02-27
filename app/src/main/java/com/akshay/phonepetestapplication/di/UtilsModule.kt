package com.akshay.phonepetestapplication.di
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().apply {
            setLenient()
        }.create()
    }

}