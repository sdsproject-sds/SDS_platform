package com.sds.security.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Joseph.Kibe. Created On 23 Jun 2026 23:30
 * <p>
 * <p>
 * Internal Custom JWT converter
 */

public class SdsJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // Map roles → ROLE_ADMIN, ROLE_SPECIALIST, etc.
        List<String> roles = jwt.getClaimAsStringList("roles");
        if (roles != null) {
            roles.forEach(role ->
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
            );
        }

        // Map permissions → CREATE, UPDATE, etc.
        List<String> permissions = jwt.getClaimAsStringList("permissions");
        if (permissions != null) {
            permissions.forEach(permission ->
                    authorities.add(new SimpleGrantedAuthority(permission.toUpperCase()))
            );
        }

        // Map scopes → SCOPE_read, etc.
        List<String> scopes = jwt.getClaimAsStringList("scope");
        if (scopes != null) {
            scopes.forEach(scope ->
                    authorities.add(new SimpleGrantedAuthority("SCOPE_" + scope))
            );
        }

        // Use user_id as the principal name
        String userId = jwt.getClaimAsString("user_id");
        String principal = (userId != null) ? userId : jwt.getSubject();

        return new JwtAuthenticationToken(jwt, authorities, principal);
    }
}
