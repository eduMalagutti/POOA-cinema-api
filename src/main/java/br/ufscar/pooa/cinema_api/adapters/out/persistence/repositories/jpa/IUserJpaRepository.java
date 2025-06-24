package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
