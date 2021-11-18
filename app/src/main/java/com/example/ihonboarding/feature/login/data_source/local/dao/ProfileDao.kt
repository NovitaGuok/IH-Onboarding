package com.example.ihonboarding.feature.login.data_source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ihonboarding.domain.login.model.Profile
import com.example.ihonboarding.feature.login.data_source.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile")
    fun getLocalProfile(): Flow<ProfileEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalProfile(profile: ProfileEntity)

    @Query("DELETE FROM profile")
    suspend fun deleteLocalProfile()
}