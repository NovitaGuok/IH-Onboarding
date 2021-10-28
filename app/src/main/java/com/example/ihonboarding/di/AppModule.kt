package com.example.ihonboarding.di

import android.content.Context
import androidx.room.Room
import com.example.ihonboarding.data.local.AppDatabase
import com.example.ihonboarding.data.local.mapper.AuthTokenEntityMapper
import com.example.ihonboarding.util.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule @Inject constructor(
    @ApplicationContext private val context: Context
) {
    @Singleton
    fun provideAuthTokenEntityMapper(): AuthTokenEntityMapper = AuthTokenEntityMapper()


    /** Database module */
    @Singleton
    fun provideAppDb() =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()

    fun provideAuthTokenDao(db: AppDatabase) = db.getAuthTokenDao()
}