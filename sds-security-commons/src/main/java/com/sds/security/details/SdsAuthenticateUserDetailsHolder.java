package com.sds.security.details;


import com.sds.security.exceptions.SdsPlatformAuthenticationException;
import lombok.*;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Joseph.Kibe. Created On 24 Jun 2026 00:01
 */

@Getter
@Setter
public class SdsAuthenticateUserDetailsHolder {

   public AuthenticatedUserDetails getAuthenticatedUserDetails(){

        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

            return new AuthenticatedUserDetails(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        }
        throw new SdsPlatformAuthenticationException("User is not authenticated");
    }

}
