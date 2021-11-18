package com.example.ihonboarding.feature.login.data_source.local

import com.example.ihonboarding.domain.login.model.Profile
import com.example.ihonboarding.feature.login.data_source.local.dao.ProfileDao
import com.example.ihonboarding.feature.login.data_source.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileLocalDataSourceImpl @Inject constructor(private val profileDao: ProfileDao) :
    ProfileLocalDataSource {
    override fun getLocalProfile(): Flow<ProfileEntity> {
        return profileDao.getLocalProfile()
    }

    override suspend fun insertLocalProfile(profile: ProfileEntity) {
        profileDao.insertLocalProfile(profile)
    }
}