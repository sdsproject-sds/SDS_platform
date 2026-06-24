package com.sds.security.details;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;

import java.io.Serial;
import java.util.List;

import java.io.Serializable;

/**
 * Represents the details of an authenticated user, encapsulating information retrieved from a JWT token.
 * This class provides methods to extract claims and additional attributes from the JWT if available,
 * or fallback to manually set values when the token is not provided.
 * It also uses logging for tracking invalid JWT objects.
 * <p>
 * The class implements Serializable to allow instances of this class to be serialized.
 */
@Setter
@Slf4j
public class AuthenticatedUserDetails implements Serializable {

    @Serial
    private static final long serialVersionUID = 6207929831199409465L;

    private final Jwt oauth2Jwt;

    private String sub;

    private List<String> roles;

    private String iss;

    private Boolean verified;

    private String aud;

    private Long nbf;

    private String userId;

    private List<String> permissions;

    private List<String> scope;

    private Long exp;

    private Long iat;

    private String jti;

    private String email;

    private String token;

    /**
     * Constructs an instance of AuthenticatedUserDetails using the provided JWT object.
     * If the provided object is not an instance of Jwt, the internal oauth2Jwt field is set to null,
     * and a warning is logged.
     * <p>
     *
     * @param jwtObject an object expected to be an instance of Jwt; if not, the oauth2Jwt field is set to null
     */
    public AuthenticatedUserDetails(Object jwtObject) {

        if (jwtObject instanceof Jwt jwt) {
            this.oauth2Jwt = jwt;
        } else {
            this.oauth2Jwt = null;
            log.warn("jwt is not a Jwt");
        }
    }

    public Jwt getOauth2Jwt() {
        return oauth2Jwt;
    }

    public String getSub() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsString("sub") : sub;
    }

    public List<String> getRoles() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsStringList("roles") : roles;
    }

    public String getIss() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsString("iss") : iss;
    }

    public Boolean isVerified() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsBoolean("verified") : verified;
    }

    public String getAud() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsString("aud") : aud;
    }

    public Long getNbf() {
        return oauth2Jwt != null ? oauth2Jwt.getClaim("nbf") : nbf;
    }

    public String getUserId() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsString("user_id") : userId;
    }

    public List<String> getPermissions() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsStringList("permissions") : permissions;
    }

    public List<String> getScope() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsStringList("scope") : scope;
    }

    public long getExp() {
        return oauth2Jwt != null ? oauth2Jwt.getClaim("exp") : exp;
    }

    public long getIat() {
        return oauth2Jwt != null ? oauth2Jwt.getClaim("iat") : iat;
    }

    public String getJti() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsString("jti") : jti;
    }

    public String getEmail() {
        return oauth2Jwt != null ? oauth2Jwt.getClaimAsString("email") : email;
    }

    public String getToken() {
        return oauth2Jwt != null ? oauth2Jwt.getTokenValue() : token;
    }

    @Override
    public String toString() {
        return
                "AuthenticatedUserDetails{" +
                        "sub = '" + sub + '\'' +
                        ",roles = '" + roles + '\'' +
                        ",iss = '" + iss + '\'' +
                        ",verified = '" + verified + '\'' +
                        ",aud = '" + aud + '\'' +
                        ",nbf = '" + nbf + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",permissions = '" + permissions + '\'' +
                        ",scope = '" + scope + '\'' +
                        ",exp = '" + exp + '\'' +
                        ",iat = '" + iat + '\'' +
                        ",jti = '" + jti + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}