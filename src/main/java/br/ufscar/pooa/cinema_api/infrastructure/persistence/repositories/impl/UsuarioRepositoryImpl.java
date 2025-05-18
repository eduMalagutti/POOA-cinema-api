package br.ufscar.pooa.cinema_api.infrastructure.persistence.repositories.impl;

import br.ufscar.pooa.cinema_api.domain.interfaces.repositories.UsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.infrastructure.persistence.entities.UsuarioEntity;
import br.ufscar.pooa.cinema_api.infrastructure.persistence.mapper.UsuarioEntityMapper;
import br.ufscar.pooa.cinema_api.infrastructure.persistence.repositories.jpa.JpaUsuarioRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final JpaUsuarioRepository jpaUsuarioRepository;
    private final UsuarioEntityMapper mapper;

    public UsuarioRepositoryImpl(JpaUsuarioRepository jpaUsuarioRepository, UsuarioEntityMapper mapper) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        if (id == null) return Optional.empty();

        Optional<UsuarioEntity> entity = jpaUsuarioRepository.findById(id);
        return entity.map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        if (email == null) return Optional.empty();

        Optional<UsuarioEntity> entity = jpaUsuarioRepository.findByEmail(email);
        return entity.map(mapper::toDomain);
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);

        System.out.println(entity.toString());

        return mapper.toDomain(jpaUsuarioRepository.save(entity));
    }

    @Override
    public void delete(Usuario usuario) {
        jpaUsuarioRepository.delete(mapper.toEntity(usuario));
    }
}
