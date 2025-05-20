package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UsuarioEntity;
import br.ufscar.pooa.cinema_api.application.mapper.ObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;

import java.util.Optional;

public class UsuarioJPaRepositoryAdapter implements IUsuarioRepository {
    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioJPaRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        if (id == null) return Optional.empty();

        Optional<UsuarioEntity> entity = usuarioJpaRepository.findById(id);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, Usuario.class));
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        if (email == null) return Optional.empty();

        Optional<UsuarioEntity> entity = usuarioJpaRepository.findByEmail(email);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, Usuario.class));
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = ObjectMapper.parseObject(usuario, UsuarioEntity.class);

        System.out.println(entity.toString());

        return ObjectMapper.parseObject(usuarioJpaRepository.save(entity), Usuario.class);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioJpaRepository.delete(ObjectMapper.parseObject(usuario, UsuarioEntity.class));
    }
}
