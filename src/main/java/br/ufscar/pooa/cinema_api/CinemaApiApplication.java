package br.ufscar.pooa.cinema_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"br.ufscar.pooa.cinema_api",
				"br.ufscar.pooa.cinema_api.infrastructure",
				"br.ufscar.pooa.cinema_api.application",
				"br.ufscar.pooa.cinema_api.presentation"
		}
)
public class CinemaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApiApplication.class, args);
	}

}
