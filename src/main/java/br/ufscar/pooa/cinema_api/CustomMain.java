package br.ufscar.pooa.cinema_api;

import br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers.UserController;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc.UserJDBCRepository;
import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUserRequestDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUserUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.IUserRepository;
import br.ufscar.pooa.cinema_api.application.useCases.RegisterUserUseCase;

public class CustomMain {
    public static void main(String[] args) {
        IUserRepository repository = new UserJDBCRepository();

        IRegisterUserUseCase useCase = new RegisterUserUseCase(repository);

        UserController controller = new UserController(useCase);

        var response = controller.register(
                new RegisterUserRequestDTO("Joe Doe", "joe@example.com", "password123")
        );

        System.out.println(response);
    }
}
