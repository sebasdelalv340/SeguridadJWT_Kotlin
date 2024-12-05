package com.es.jwtSecurityKotlin.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.stereotype.Service
import java.time.Instant
import java.time.temporal.ChronoUnit

@Service
class TokenService {

    @Autowired
    private lateinit var jwtEncoder: JwtEncoder

    fun generarToken(authentication: Authentication): String {

        val roles: String = authentication
            .authorities
            .map { it.authority }
            .joinToString { " " }
        
        val payload: JwtClaimsSet = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(Instant.now())
            .expiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
            .subject(authentication.name)
            .claim("roles", roles)
            .build()


        return jwtEncoder.encode(JwtEncoderParameters.from(payload)).tokenValue
    }
}