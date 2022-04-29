package com.cesarwillymc.technicaltestwordbox.data.di

import com.cesarwillymc.technicaltestwordbox.BuildConfig
import com.cesarwillymc.technicaltestwordbox.data.source.randomPeople.framework.PeopleService
import com.cesarwillymc.technicaltestwordbox.extension.OkHttpHelper.getOkHttpBuilder
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun gson() = Gson()

    @Singleton
    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesPeopleRandomOkhttp(
        loggingInterceptor: HttpLoggingInterceptor
    ) = getOkHttpBuilder(loggingInterceptor).build()

    @Singleton
    @Provides
    fun providesPeopleRandom(
        okHttpClient: OkHttpClient
    ) = provideServiceRandomUser<PeopleService>(okHttpClient)

    @Singleton
    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private inline fun <reified T : Any> provideServiceRandomUser(
        okhttpClient: OkHttpClient
    ): T {
        return providesRetrofit(okhttpClient).create(T::class.java)
    }
}
