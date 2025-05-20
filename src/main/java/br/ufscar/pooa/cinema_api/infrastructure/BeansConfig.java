package br.ufscar.pooa.cinema_api.infrastructure;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc.UsuarioJDBCRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public IUsuarioRepository usuarioRepository() {
        return new UsuarioJDBCRepository();
    }
}
