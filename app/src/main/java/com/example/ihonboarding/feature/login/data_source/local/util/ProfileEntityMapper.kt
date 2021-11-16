package com.example.ihonboarding.feature.login.data_source.local.util

import com.example.ihonboarding.domain.login.model.Profile
import com.example.ihonboarding.domain.login.util.DomainMapper
import com.example.ihonboarding.feature.login.data_source.local.entity.ProfileEntity

class ProfileEntityMapper : DomainMapper<ProfileEntity, Profile> {
    override fun mapToDomainModel(model: ProfileEntity): Profile {
        return Profile(
            username = model.username,
            bio = model.bio,
            name = model.name,
            picture = model.picture,
            web = model.web
        )
    }

    override fun mapFromDomainModel(domainModel: Profile): ProfileEntity {
        return ProfileEntity(
            username = domainModel.username,
            bio = domainModel.bio,
            name = domainModel.name,
            picture = domainModel.picture,
            web = domainModel.web
        )
    }

}