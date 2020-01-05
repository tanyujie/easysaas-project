package org.easymis.easycrm.web.security.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * Thrown if an authentication request is rejected because the credentials are invalid.
 * For this exception to be thrown, it means the account is neither locked nor disabled.
 *
 * @author Ben Alex
 */
public class TokenAuthenticationException extends AuthenticationException {
    // ~ Constructors
    // ===================================================================================================

    /**
     * Constructs a <code>BadCredentialsException</code> with the specified message.
     *
     * @param msg the detail message
     */
    public TokenAuthenticationException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>BadCredentialsException</code> with the specified message and
     * root cause.
     *
     * @param msg the detail message
     * @param t root cause
     */
    public TokenAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}