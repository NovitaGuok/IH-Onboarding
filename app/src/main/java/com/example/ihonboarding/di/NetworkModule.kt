package com.example.ihonboarding.di

import com.example.ihonboarding.BuildConfig
import com.example.ihonboarding.data.network.AuthService
import com.example.ihonboarding.data.network.mapper.AuthTokenDtoMapper
import com.example.ihonboarding.data.network.source.AuthTokenRemoteSource
import com.example.ihonboarding.data.network.source.AuthTokenRemoteSourceImpl
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
object NetworkModule {
    @Singleton
    @Provides
    fun provideAuthTokenDtoMapper(): AuthTokenDtoMapper {
        return AuthTokenDtoMapper()
    }

    @Singleton
    @Provides
    fun provideAuthTokenRemoteSource(authService: AuthService): AuthTokenRemoteSource {
        return AuthTokenRemoteSourceImpl(authService)
    }

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }
}