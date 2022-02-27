package com.akshay.phonepetestapplication.di
import com.akshay.phonepetestapplication.network.Constants.BASE_URL
import com.akshay.phonepetestapplication.network.Constants.TIMEOUT
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(TIMEOUT, TimeUnit.MINUTES)
            writeTimeout(TIMEOUT, TimeUnit.MINUTES)
            readTimeout(TIMEOUT, TimeUnit.MINUTES)
        }.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            client(okHttpClient)
            addConverterFactory(ScalarsConverterFactory.create())
            addConverterFactory(GsonConverterFactory.create(gson))
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        }.build()
    }

}