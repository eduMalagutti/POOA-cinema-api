package br.ufscar.pooa.cinema_api.infrastructure;

import framework.FrameworkClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFrameworkFactory {
    @Value( "${spring.datasource.url}")
    private String dbUrl;

    @Value( "${spring.datasource.username}")
    private String dbUser;

    @Value( "${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public FrameworkClass myFrameworkGrupo1(){
        return new FrameworkClass(dbUrl, dbUser, dbPassword);
    }
}
