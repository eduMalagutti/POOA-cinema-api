package br.ufscar.pooa.cinema_api.application.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entity, String key, String value) {
        super(entity + " not found with" + key + " " + value + ".");
    }
}
