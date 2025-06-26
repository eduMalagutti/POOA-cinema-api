package br.ufscar.pooa.cinema_api;

import br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers.UserController;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc.UserJDBCRepository;
import br.ufscar.pooa.cinema_api.application.dtos.user.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUserUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IUserRepository;
import br.ufscar.pooa.cinema_api.application.usecases.user.RegisterUserUseCase;
import br.ufscar.pooa.cinema_api.domain.enums.Role;
import br.ufscar.pooa.cinema_api.infrastructure.mapper.ObjectMapper;

import java.util.logging.Logger;

public class CustomMain {
    private static final Logger logger = Logger.getLogger(CustomMain.class.getName());

    public static void main(String[] args) {
        IUserRepository repository = new UserJDBCRepository();
        IObjectMapper objectMapper = new ObjectMapper();

        IRegisterUserUseCase useCase = new RegisterUserUseCase(repository, objectMapper);

        UserController controller = new UserController(useCase);

        var response = controller.register(
                new RegisterUserRequestDTO("Joe Doe", "joe@example.com", "password123", Role.ADMIN)
        );

        logger.info(response.toString());
    }
}
