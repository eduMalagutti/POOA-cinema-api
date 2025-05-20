package br.ufscar.pooa.cinema_api;

import br.ufscar.pooa.cinema_api.adapters.in.presentation.controllers.UsuarioController;
import br.ufscar.pooa.cinema_api.adapters.out.persistence.repositories.jdbc.UsuarioJDBCRepository;
import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterUsuarioUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import br.ufscar.pooa.cinema_api.application.usecases.RegisterUsuarioUseCase;

public class CustomMain {
    public static void main(String[] args) {
        IUsuarioRepository repository = new UsuarioJDBCRepository();

        IRegisterUsuarioUseCase useCase = new RegisterUsuarioUseCase(repository);

        UsuarioController controller = new UsuarioController(useCase);

        var response = controller.register(
                new RegisterUsuarioRequestDTO("Joe Doe", "joe@example.com", "password123")
        );

        System.out.println(response);
    }
}
