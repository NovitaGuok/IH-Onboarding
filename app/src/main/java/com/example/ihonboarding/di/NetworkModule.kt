package com.example.ihonboarding.di

import com.example.ihonboarding.BuildConfig
import com.example.ihonboarding.domain.login.use_case.RefreshTokenUseCase
import com.example.ihonboarding.feature.login.data_source.remote.api.AuthService
import com.example.ihonboarding.feature.login.data_source.remote.interceptor.AuthInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(refreshTokenUseCase: RefreshTokenUseCase): AuthInterceptor {
        return AuthInterceptor(refreshTokenUseCase)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authInterceptor: AuthInterceptor): OkHttpClient {
        var okHttp = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) okHttp = okHttp.addInterceptor(httpLoggingInterceptor)
        return okHttp.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
    }
}