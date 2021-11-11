package com.example.ihonboarding.di

import android.app.Application
import androidx.room.Room
import com.example.ihonboarding.feature.home.data_source.local.db.NewsDb
import com.example.ihonboarding.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideNewsDb(app: Application): NewsDb {
        return Room.databaseBuilder(app, NewsDb::class.java, DATABASE_NAME).build()
    }

    @Provides
    fun provideNewsDao(newsDb: NewsDb) = newsDb.newsDao()
}