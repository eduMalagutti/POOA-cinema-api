package br.ufscar.pooa.cinema_api.application.ports.out.repository;

import br.ufscar.pooa.cinema_api.domain.User;

import java.util.Optional;

public interface IUserRepository {
    User save(User usuario);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    void delete(User usuario);
}
