package com.example.ihonboarding.feature.login.data_source.remote.util

import com.example.ihonboarding.domain.login.model.Profile
import com.example.ihonboarding.domain.login.util.DomainMapper
import com.example.ihonboarding.feature.login.data_source.remote.dto.ProfileDto

class ProfileDtoMapper : DomainMapper<ProfileDto, Profile> {
    override fun mapToDomainModel(model: ProfileDto): Profile {
        return Profile(
            username = model.username,
            bio = model.bio,
            name = model.name,
            picture = model.picture,
            web = model.web
        )
    }

    override fun mapFromDomainModel(domainModel: Profile): ProfileDto {
        return ProfileDto(
            username = domainModel.username,
            bio = domainModel.bio,
            name = domainModel.name,
            picture = domainModel.picture,
            web = domainModel.web
        )
    }

}