package com.akshay.phonepetestapplication.di

import com.akshay.phonepetestapplication.network.api.MoviesContentAPI
import com.akshay.phonepetestapplication.repository.HomeRepository
import com.akshay.phonepetestapplication.repository.HomeRepositoryImpl
import com.akshay.phonepetestapplication.repository.MainRepository
import com.akshay.phonepetestapplication.repository.MainRepositoryImpl
import com.akshay.phonepetestapplication.usecases.CharacterOperationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun provideMainRepository(
        moviesContentAPI: MoviesContentAPI,
        characterOperationUseCase: CharacterOperationUseCase
    ): MainRepository {
        return MainRepositoryImpl(
            moviesContentAPI,
            characterOperationUseCase
        )
    }

    @Provides
    fun provideHomeRepository(
        moviesContentAPI: MoviesContentAPI,
    ): HomeRepository {
        return HomeRepositoryImpl(
            moviesContentAPI,
        )
    }
}
