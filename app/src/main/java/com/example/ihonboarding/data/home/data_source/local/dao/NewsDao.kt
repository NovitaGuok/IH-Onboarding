package com.example.ihonboarding.data.home.data_source.local.dao

import androidx.room.*
import com.example.ihonboarding.domain.home.model.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
   @Query("SELECT * FROM news")
   fun getNewsList(): Flow<List<NewsEntity>>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertNews(newsEntity: NewsEntity)

   @Delete
   suspend fun deleteNews(newsEntity: NewsEntity)
}