package br.ufscar.pooa.cinema_api.infrastructure.persistence_framework;

import java.util.List;
import java.util.Optional;

public interface IFrameworkRepository<T, ID> {
    T save(T entity);

    Optional<T> findById(ID id);

    Optional<T> findBy(String fieldName, Object value);

    List<T> findAll();

    boolean existsById(ID id);

    boolean existsBy(String fieldName, Object value);

    T update(T entity);

    T delete(T entity);
}