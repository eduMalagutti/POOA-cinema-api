package br.ufscar.pooa.cinema_api.application.exceptions;

public class ResourceNotExistsException extends RuntimeException {
    public ResourceNotExistsException(String message) {
        super(message);
    }
}
