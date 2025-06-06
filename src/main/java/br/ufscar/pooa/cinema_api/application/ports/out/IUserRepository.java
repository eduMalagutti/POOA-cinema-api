package br.ufscar.pooa.cinema_api.application.ports.out;

import br.ufscar.pooa.cinema_api.domain.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User save(User usuario);
    void delete(User usuario);
}
