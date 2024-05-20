package org.devhamzat.userauthentication.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String error) {
        super(error);
    }
}
