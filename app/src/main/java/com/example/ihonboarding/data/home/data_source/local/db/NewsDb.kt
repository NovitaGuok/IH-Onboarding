package com.example.ihonboarding.data.home.data_source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihonboarding.data.home.data_source.local.dao.NewsDao
import com.example.ihonboarding.domain.home.model.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsDb: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}