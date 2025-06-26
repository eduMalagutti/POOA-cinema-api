package br.ufscar.pooa.cinema_api.application.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String entity, String key, String value) {
        super(entity + " already exists with " + key + " " + value + ".");
    }
}
