package br.ufscar.pooa.cinema_api.adapters.persistence.repositories.impl;

import br.ufscar.pooa.cinema_api.adapters.persistence.entities.UsuarioEntity;
import br.ufscar.pooa.cinema_api.adapters.persistence.repositories.jpa.JpaUsuarioRepository;
import br.ufscar.pooa.cinema_api.application.gateways.UsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.application.mapper.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    private final JpaUsuarioRepository jpaUsuarioRepository;

    public UsuarioRepositoryImpl(JpaUsuarioRepository jpaUsuarioRepository) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        if (id == null) return Optional.empty();

        Optional<UsuarioEntity> entity = jpaUsuarioRepository.findById(id);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, Usuario.class));
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        if (email == null) return Optional.empty();

        Optional<UsuarioEntity> entity = jpaUsuarioRepository.findByEmail(email);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, Usuario.class));
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = ObjectMapper.parseObject(usuario, UsuarioEntity.class);

        System.out.println(entity.toString());

        return ObjectMapper.parseObject(jpaUsuarioRepository.save(entity), Usuario.class);
    }

    @Override
    public void delete(Usuario usuario) {
        jpaUsuarioRepository.delete(ObjectMapper.parseObject(usuario, UsuarioEntity.class));
    }
}
