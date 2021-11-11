package com.example.ihonboarding.feature.home.data_source.local.dao

import androidx.room.*
import com.example.ihonboarding.domain.home.model.News
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
   @Query("SELECT * FROM news")
   fun getLocalNewsList(): Flow<List<News>>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertLocalNews(news: News)
}