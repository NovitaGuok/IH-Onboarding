package com.example.ihonboarding.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ihonboarding.data.local.entity.AuthTokenEntity

@Dao
interface AuthTokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(authTokenEntity: AuthTokenEntity): Long

    @Query("UPDATE auth_token SET token = null WHERE id = :id")
    fun nullifyToken(id: Int): Int

    @Query("SELECT * FROM auth_token WHERE id = :id")
    suspend fun searchById(id: Int): AuthTokenEntity?

    @Query("SELECT * FROM auth_token WHERE email = :email")
    suspend fun searchByEmail(email: String): AuthTokenEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAndReplace(authTokenEntity: AuthTokenEntity): Long
}