package com.example.ihonboarding.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ihonboarding.data.model.News

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(news: List<News>)

    @Query("DELETE FROM news")
    suspend fun deleteAllNews()

    @Query("SELECT * FROM news")
    suspend fun getNews(): List<News>
}