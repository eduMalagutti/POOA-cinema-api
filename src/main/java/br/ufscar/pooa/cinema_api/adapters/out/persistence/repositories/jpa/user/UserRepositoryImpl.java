package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jpa.user;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UserEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.mapper.ObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.domain.User;

import java.util.Optional;

public class UserRepositoryImpl implements IUserRepository {
    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null) return Optional.empty();

        Optional<UserEntity> entity = userJpaRepository.findById(id);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, User.class));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        if (email == null) return Optional.empty();

        Optional<UserEntity> entity = userJpaRepository.findByEmail(email);
        return Optional.ofNullable(ObjectMapper.parseObject(entity, User.class));
    }

    @Override
    public User save(User usuario) {
        UserEntity entity = ObjectMapper.parseObject(usuario, UserEntity.class);

        System.out.println(entity.toString());

        return ObjectMapper.parseObject(userJpaRepository.save(entity), User.class);
    }

    @Override
    public void delete(User usuario) {
        userJpaRepository.delete(ObjectMapper.parseObject(usuario, UserEntity.class));
    }
}
