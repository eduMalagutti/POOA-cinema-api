package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.client;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
}