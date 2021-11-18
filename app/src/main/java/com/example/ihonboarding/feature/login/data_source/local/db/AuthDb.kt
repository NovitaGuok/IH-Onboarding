package com.example.ihonboarding.feature.login.data_source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ihonboarding.feature.login.data_source.local.dao.ProfileDao
import com.example.ihonboarding.feature.login.data_source.local.entity.ProfileEntity

@Database(entities = [ProfileEntity::class], version = 1, exportSchema = false)
abstract class AuthDb : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}