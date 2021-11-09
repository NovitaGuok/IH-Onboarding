package com.example.ihonboarding.domain.home.use_case

import android.util.Log
import com.example.ihonboarding.data.home.data_source.remote.dto.toSingleNews
import com.example.ihonboarding.domain.home.model.News
import com.example.ihonboarding.domain.home.repository.NewsRepository
import com.example.ihonboarding.util.Constants.Companion.TAG
import com.example.ihonboarding.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(): Flow<Resource<List<News>>> = flow {
        newsRepository.getNewsList().asFlow().map {
            it
        }.onCompletion {
            Log.d(TAG, "onCompletion")
        }.collect {
            Log.d(TAG, it.toString())
        }
    }
}