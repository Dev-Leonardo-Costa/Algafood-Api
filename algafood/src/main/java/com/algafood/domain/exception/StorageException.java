package com.algafood.domain.exception;

public class StorageException extends NegocioException{

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
