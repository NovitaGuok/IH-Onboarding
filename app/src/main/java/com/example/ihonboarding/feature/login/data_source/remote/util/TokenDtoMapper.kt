package com.example.ihonboarding.feature.login.data_source.remote.util

import com.example.ihonboarding.domain.login.model.Token
import com.example.ihonboarding.domain.login.util.DomainMapper
import com.example.ihonboarding.feature.login.data_source.remote.dto.TokenDto

class TokenDtoMapper : DomainMapper<TokenDto, Token> {
    override fun mapToDomainModel(model: TokenDto): Token {
        return Token(
            expiresAt = model.expiresAt,
            token = model.token
        )
    }

    override fun mapFromDomainModel(domainModel: Token): TokenDto {
        return TokenDto(
            expiresAt = domainModel.expiresAt,
            token = domainModel.token,
            scheme = "Bearer"
        )
    }
}