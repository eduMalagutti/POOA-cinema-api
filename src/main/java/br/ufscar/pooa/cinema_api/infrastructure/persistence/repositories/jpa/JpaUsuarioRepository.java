package br.ufscar.pooa.cinema_api.infrastructure.persistence.repositories.jpa;

import br.ufscar.pooa.cinema_api.infrastructure.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
