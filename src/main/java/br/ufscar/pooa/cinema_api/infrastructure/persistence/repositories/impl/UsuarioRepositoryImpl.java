package br.ufscar.pooa.cinema_api.infrastructure.persistence.repositories.impl;

import br.ufscar.pooa.cinema_api.application.port.out.UsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.infrastructure.mapper.UsuarioMapper;
import br.ufscar.pooa.cinema_api.infrastructure.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final JpaRepository<UsuarioEntity, Long> jpaRepository;
    private final UsuarioMapper mapper;

    public UsuarioRepositoryImpl(JpaRepository<UsuarioEntity, Long> jpaRepository, UsuarioMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario findById(Long id) {
        Optional<UsuarioEntity> entity = jpaRepository.findById(id);
        return entity.map(mapper::toDomain).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);

        System.out.println(entity.toString());

        return mapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Usuario usuario) {
        jpaRepository.delete(mapper.toEntity(usuario));
    }
}
