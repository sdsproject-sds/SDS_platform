package com.sds.security.details;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AuthenticatedUserDetails Tests")
class AuthenticatedUserDetailsTest {

    @Nested
    @DisplayName("Constructor Tests")
    class ConstructorTests {

        @Test
        @DisplayName("Should set oauth2Jwt to null when non-Jwt object is provided")
        void shouldSetOauth2JwtToNullWhenInvalidObjectProvided() {
            AuthenticatedUserDetails details = new AuthenticatedUserDetails("not-a-jwt");

            assertNull(details.getOauth2Jwt());
        }

        @Test
        @DisplayName("Should set oauth2Jwt to null when null is provided")
        void shouldSetOauth2JwtToNullWhenNullProvided() {
            AuthenticatedUserDetails details = new AuthenticatedUserDetails(null);

            assertNull(details.getOauth2Jwt());
        }
    }

    @Nested
    @DisplayName("Without Jwt - fallback to manually set fields")
    class WithoutJwtTests {

        private AuthenticatedUserDetails buildDetails() {
            return new AuthenticatedUserDetails("invalid-object");
        }

        @Test
        @DisplayName("getSub() should return manually set value")
        void shouldGetSubFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setSub("manual-sub");

            assertEquals("manual-sub", details.getSub());
        }

        @Test
        @DisplayName("getRoles() should return manually set value")
        void shouldGetRolesFromField() {
            AuthenticatedUserDetails details = buildDetails();
            List<String> roles = List.of("ROLE_USER", "ROLE_ADMIN");
            details.setRoles(roles);

            assertEquals(roles, details.getRoles());
        }

        @Test
        @DisplayName("getIss() should return manually set value")
        void shouldGetIssFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setIss("https://manual-issuer.com");

            assertEquals("https://manual-issuer.com", details.getIss());
        }

        @Test
        @DisplayName("isVerified() should return manually set value - true")
        void shouldGetVerifiedTrueFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setVerified(true);

            assertTrue(details.isVerified());
        }

        @Test
        @DisplayName("isVerified() should return manually set value - false")
        void shouldGetVerifiedFalseFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setVerified(false);

            assertFalse(details.isVerified());
        }

        @Test
        @DisplayName("getAud() should return manually set value")
        void shouldGetAudFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setAud("manual-audience");

            assertEquals("manual-audience", details.getAud());
        }

        @Test
        @DisplayName("getNbf() should return manually set value")
        void shouldGetNbfFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setNbf(1700000000L);

            assertEquals(1700000000L, details.getNbf());
        }

        @Test
        @DisplayName("getUserId() should return manually set value")
        void shouldGetUserIdFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setUserId("manual-user-id");

            assertEquals("manual-user-id", details.getUserId());
        }

        @Test
        @DisplayName("getPermissions() should return manually set value")
        void shouldGetPermissionsFromField() {
            AuthenticatedUserDetails details = buildDetails();
            List<String> permissions = List.of("read", "write");
            details.setPermissions(permissions);

            assertEquals(permissions, details.getPermissions());
        }

        @Test
        @DisplayName("getScope() should return manually set value")
        void shouldGetScopeFromField() {
            AuthenticatedUserDetails details = buildDetails();
            List<String> scope = List.of("openid", "profile");
            details.setScope(scope);

            assertEquals(scope, details.getScope());
        }

        @Test
        @DisplayName("getExp() should return manually set value")
        void shouldGetExpFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setExp(1700003600L);

            assertEquals(1700003600L, details.getExp());
        }

        @Test
        @DisplayName("getIat() should return manually set value")
        void shouldGetIatFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setIat(1700000000L);

            assertEquals(1700000000L, details.getIat());
        }

        @Test
        @DisplayName("getJti() should return manually set value")
        void shouldGetJtiFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setJti("manual-jti");

            assertEquals("manual-jti", details.getJti());
        }

        @Test
        @DisplayName("getEmail() should return manually set value")
        void shouldGetEmailFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setEmail("user@example.com");

            assertEquals("user@example.com", details.getEmail());
        }

        @Test
        @DisplayName("getToken() should return manually set value")
        void shouldGetTokenFromField() {
            AuthenticatedUserDetails details = buildDetails();
            details.setToken("manual-token");

            assertEquals("manual-token", details.getToken());
        }

        @Test
        @DisplayName("Should return null for unset fields")
        void shouldReturnNullForUnsetFields() {
            AuthenticatedUserDetails details = buildDetails();

            assertAll(
                    () -> assertNull(details.getSub()),
                    () -> assertNull(details.getRoles()),
                    () -> assertNull(details.getIss()),
                    () -> assertNull(details.isVerified()),
                    () -> assertNull(details.getAud()),
                    () -> assertNull(details.getNbf()),
                    () -> assertNull(details.getUserId()),
                    () -> assertNull(details.getPermissions()),
                    () -> assertNull(details.getScope()),
                    () -> assertNull(details.getJti()),
                    () -> assertNull(details.getEmail()),
                    () -> assertNull(details.getToken())
            );
        }
    }

    @Nested
    @DisplayName("toString() Tests")
    class ToStringTests {

        @Test
        @DisplayName("toString() should contain all expected field names")
        void shouldContainAllFieldNames() {
            AuthenticatedUserDetails details = new AuthenticatedUserDetails("invalid");

            String result = details.toString();

            assertAll(
                    () -> assertTrue(result.contains("AuthenticatedUserDetails{")),
                    () -> assertTrue(result.contains("sub")),
                    () -> assertTrue(result.contains("roles")),
                    () -> assertTrue(result.contains("iss")),
                    () -> assertTrue(result.contains("verified")),
                    () -> assertTrue(result.contains("aud")),
                    () -> assertTrue(result.contains("nbf")),
                    () -> assertTrue(result.contains("user_id")),
                    () -> assertTrue(result.contains("permissions")),
                    () -> assertTrue(result.contains("scope")),
                    () -> assertTrue(result.contains("exp")),
                    () -> assertTrue(result.contains("iat")),
                    () -> assertTrue(result.contains("jti")),
                    () -> assertTrue(result.contains("email"))
            );
        }

        @Test
        @DisplayName("toString() should reflect manually set field values")
        void shouldReflectManuallySetValues() {
            AuthenticatedUserDetails details = new AuthenticatedUserDetails("invalid");
            details.setSub("test-sub");
            details.setEmail("test@example.com");

            String result = details.toString();

            assertAll(
                    () -> assertTrue(result.contains("test-sub")),
                    () -> assertTrue(result.contains("test@example.com"))
            );
        }
    }

    @Nested
    @DisplayName("Serializable Tests")
    class SerializableTests {

        @Test
        @DisplayName("Should implement Serializable")
        void shouldImplementSerializable() {
            AuthenticatedUserDetails details = new AuthenticatedUserDetails("invalid");

            assertInstanceOf(Serializable.class, details);
        }
    }
}