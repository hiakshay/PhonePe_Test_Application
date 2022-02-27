package com.akshay.phonepetestapplication.di
import com.akshay.phonepetestapplication.usecases.CharacterOperationUseCase
import com.akshay.phonepetestapplication.usecases.CharacterOperationUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    fun provideCharacterUseCase(
    ): CharacterOperationUseCase {
        return CharacterOperationUseCaseImpl()
    }
}
