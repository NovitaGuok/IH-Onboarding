package com.example.ihonboarding.feature.login.repository

import com.example.ihonboarding.domain.login.model.Profile
import com.example.ihonboarding.domain.login.repository.ProfileRepository
import com.example.ihonboarding.feature.login.data_source.local.ProfileLocalDataSource
import com.example.ihonboarding.feature.login.data_source.local.util.ProfileEntityMapper
import com.example.ihonboarding.feature.login.data_source.remote.ProfileRemoteDataSource
import com.example.ihonboarding.feature.login.data_source.remote.util.ProfileDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileRemoteDataSource: ProfileRemoteDataSource,
    private val profileLocalDataSource: ProfileLocalDataSource
) : ProfileRepository {
    override fun getProfile(): Flow<Profile> {
        return flow {
            try {
                val res = profileRemoteDataSource.getProfile().body()
                val profileDtoMapper = ProfileDtoMapper()
                val domainProfile = profileDtoMapper.mapToDomainModel(res!!)
                saveToLocalDb(domainProfile)
                emit(domainProfile)
            } catch (e: Exception) {
                throw Throwable(e)
            }
        }.flowOn(Dispatchers.IO)
    }

    private suspend fun saveToLocalDb(profile: Profile) {
        val profileEntityMapper = ProfileEntityMapper()
        val res = profile.let { profileEntityMapper.mapFromDomainModel(it) }
        profileLocalDataSource.insertLocalProfile(res)
    }
}