package com.example.ihonboarding.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihonboarding.data.local.dao.AuthTokenDao
import com.example.ihonboarding.data.local.entity.AuthTokenEntity
import com.example.ihonboarding.util.DATABASE_NAME

@Database(entities = [AuthTokenEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAuthTokenDao() : AuthTokenDao

    companion object {
        const val DB_NAME = DATABASE_NAME
    }
}