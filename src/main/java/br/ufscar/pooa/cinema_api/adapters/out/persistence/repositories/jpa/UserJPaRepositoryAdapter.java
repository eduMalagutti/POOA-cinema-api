package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UserEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.mapper.ObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.domain.model.User;

import java.util.Optional;

public class UserJPaRepositoryAdapter implements IUserRepository {
    private final IUserJpaRepository IUserJpaRepository;

    public UserJPaRepositoryAdapter(IUserJpaRepository IUserJpaRepository) {
        this.IUserJpaRepository = IUserJpaRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null) return Optional.empty();

        Optional<UserEntity> entity = IUserJpaRepository.findById(id);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, User.class));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        if (email == null) return Optional.empty();

        Optional<UserEntity> entity = IUserJpaRepository.findByEmail(email);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, User.class));
    }

    @Override
    public User save(User usuario) {
        UserEntity entity = ObjectMapper.parseObject(usuario, UserEntity.class);

        System.out.println(entity.toString());

        return ObjectMapper.parseObject(IUserJpaRepository.save(entity), User.class);
    }

    @Override
    public void delete(User usuario) {
        IUserJpaRepository.delete(ObjectMapper.parseObject(usuario, UserEntity.class));
    }
}
