package com.example.ihonboarding.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihonboarding.data.dao.NewsDao
import com.example.ihonboarding.data.model.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDb : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}