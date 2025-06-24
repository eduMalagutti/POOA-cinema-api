package br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.persistence_framework;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UserEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.mapper.ObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.domain.model.User;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.IFrameworkRepository;

import java.util.Optional;

public class UserPersistenceFrameworkRepository implements IUserRepository {
    private final IFrameworkRepository<UserEntity, Long> frameworkRepository;

    public UserPersistenceFrameworkRepository(IFrameworkRepository<UserEntity, Long> frameworkRepository) {
        this.frameworkRepository = frameworkRepository;
    }

    @Override
    public User save(User usuario) {
        UserEntity entity = ObjectMapper.parseObject(usuario, UserEntity.class);

        entity = frameworkRepository.save(entity);

        return ObjectMapper.parseObject(entity, User.class);
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<UserEntity> entity = frameworkRepository.findById(id);

        return entity.map(userEntity -> ObjectMapper.parseObject(userEntity, User.class));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> entity = frameworkRepository.findBy("email", email);

        return entity.map(userEntity -> ObjectMapper.parseObject(userEntity, User.class));
    }

    @Override
    public void delete(User usuario) {
    }
}
