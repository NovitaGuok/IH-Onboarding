package com.example.ihonboarding.di

import android.content.Context
import androidx.room.Room
import com.example.ihonboarding.data.local.AppDatabase
import com.example.ihonboarding.data.local.dao.AuthTokenDao
import com.example.ihonboarding.data.local.util.AuthTokenEntityMapper
import com.example.ihonboarding.util.DATABASE_NAME
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
    fun provideAuthTokenEntityMapper(): AuthTokenEntityMapper = AuthTokenEntityMapper()


    /** Database module */
    @Singleton
    @Provides
    fun provideAppDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()


    @Provides
    fun provideAuthTokenDao(db: AppDatabase) = db.getAuthTokenDao()

}