package com.akshay.phonepetestapplication.di
import android.content.Context
import com.akshay.phonepetestapplication.PhonePeTestApplication
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
    fun provideApplication(@ApplicationContext app: Context): PhonePeTestApplication {
        return app as PhonePeTestApplication
    }

}