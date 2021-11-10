package com.example.ihonboarding.data_source.home.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihonboarding.data_source.home.local.dao.NewsDao
import com.example.ihonboarding.domain.home.model.News

@Database(entities = [News::class], version = 1)
abstract class NewsDb: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}