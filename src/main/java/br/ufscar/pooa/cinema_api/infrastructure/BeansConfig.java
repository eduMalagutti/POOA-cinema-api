package br.ufscar.pooa.cinema_api.infrastructure;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc.UserJDBCRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public IUserRepository usuarioRepository() {
        return new UserJDBCRepository();
    }
}
