
package br.ufscar.pooa.cinema_api.infrastructure;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.UserEntity;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.persistence_framework.UserPersistenceFrameworkRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.IFrameworkRepository;
import br.ufscar.pooa.cinema_api.infrastructure.persistence_framework.SimpleFrameworkRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class BeansFactory {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    DatabaseManager databaseManager() throws SQLException {
        return new DatabaseManager(url, user, password);
    }

    @Bean
    IFrameworkRepository<UserEntity, Long> userPersistenceFrameworkRepository(DatabaseManager databaseManager) {
        return new SimpleFrameworkRepository<>(databaseManager, UserEntity.class);
    }

    @Bean
    public IUserRepository usuarioRepository(IFrameworkRepository<UserEntity, Long> userPersistenceFrameworkRepository) {
        return new UserPersistenceFrameworkRepository(userPersistenceFrameworkRepository);
    }
}