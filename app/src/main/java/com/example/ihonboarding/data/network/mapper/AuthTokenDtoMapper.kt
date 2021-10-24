package com.example.ihonboarding.data.network.mapper

import com.example.ihonboarding.data.network.model.AuthTokenDto
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.domain.mapper.DomainMapper

class AuthTokenDtoMapper : DomainMapper<AuthTokenDto, AuthToken> {
    override fun mapToDomainModel(model: AuthTokenDto): AuthToken {
        return AuthToken(
            token = model.token,
            error = model.error
        )
    }

    override fun mapFromDomainModel(domainModel: AuthToken): AuthTokenDto {
        return AuthTokenDto(
            token = domainModel.token,
            error = domainModel.error
        )
    }
}