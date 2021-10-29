package com.example.ihonboarding.di

import android.content.Context
import androidx.room.Room
import com.example.ihonboarding.data.local.AppDatabase
import com.example.ihonboarding.data.local.mapper.AuthTokenEntityMapper
import com.example.ihonboarding.util.DATABASE_NAME
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    fun provideAuthTokenEntityMapper(): AuthTokenEntityMapper = AuthTokenEntityMapper()

    /** Database module */
    @Singleton
    fun provideAppDb(context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    fun provideAuthTokenDao(db: AppDatabase) = db.getAuthTokenDao()
}