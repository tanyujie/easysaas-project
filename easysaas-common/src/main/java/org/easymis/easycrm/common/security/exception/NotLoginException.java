package org.easymis.easycrm.common.security.exception;

public class NotLoginException extends RuntimeException {
    public NotLoginException(String msg) {
        super(msg);
    }

    public NotLoginException() {
    }

}
