package com.example.ihonboarding.data.home.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihonboarding.data.home.dao.NewsDao
import com.example.ihonboarding.data.home.model.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}