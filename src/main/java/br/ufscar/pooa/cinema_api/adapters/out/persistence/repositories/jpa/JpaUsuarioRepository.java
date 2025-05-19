package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByEmail(String email);
}
