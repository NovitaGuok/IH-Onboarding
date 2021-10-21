package com.example.ihonboarding.data.local.util

import com.example.ihonboarding.data.local.entity.AuthTokenEntity
import com.example.ihonboarding.domain.model.AuthToken
import com.example.ihonboarding.domain.util.DomainMapper

class AuthTokenEntityMapper : DomainMapper<AuthTokenEntity, AuthToken>{
    override fun mapToDomainModel(model: AuthTokenEntity): AuthToken {
        return AuthToken(
            id = model.id,
            token = model.token
        )
    }

    override fun mapFromDomainModel(domainModel: AuthToken): AuthTokenEntity {
        return AuthTokenEntity(
            id = domainModel.id,
            token = domainModel.token
        )
    }

}