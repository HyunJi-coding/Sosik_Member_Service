package com.example.sosikmemberservice.repository;

import java.util.Optional;

public interface RefreshTokenRepository {
    void save(final String refreshToken, final String memberIdentifier);

    Optional<String> findMemberIdentifierByRefreshToken(final String refreshToken);
}
