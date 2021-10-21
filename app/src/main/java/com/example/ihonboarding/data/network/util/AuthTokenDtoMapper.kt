package com.example.ihonboarding.data.network.util

import com.example.ihonboarding.data.network.model.AuthTokenDto
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.domain.util.DomainMapper

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