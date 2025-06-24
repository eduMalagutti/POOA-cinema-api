package br.ufscar.pooa.cinema_api.application.ports.out;

import br.ufscar.pooa.cinema_api.domain.model.User;

import java.util.Optional;

public interface IUserRepository {
    User save(User usuario);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    void delete(User usuario);
}
