package com.example.ihonboarding.di

import android.app.Application
import androidx.room.Room
import com.example.ihonboarding.feature.login.data_source.local.db.AuthDb
import com.example.ihonboarding.util.Constant.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAuthDb(app: Application): AuthDb {
        return Room.databaseBuilder(app, AuthDb::class.java, DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun provideProfileDao(authDb: AuthDb) = authDb.profileDao()
}