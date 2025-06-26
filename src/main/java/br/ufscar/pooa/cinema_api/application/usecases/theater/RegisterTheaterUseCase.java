package br.ufscar.pooa.cinema_api.application.usecases.theater;

import br.ufscar.pooa.cinema_api.application.dtos.theater.RegisterTheaterRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.theater.TheaterResponseDTO;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterTheaterUseCase;
import org.springframework.stereotype.Service;

@Service
public class RegisterTheaterUseCase implements IRegisterTheaterUseCase {

    @Override
    public TheaterResponseDTO execute(RegisterTheaterRequestDTO requestDTO) {
        return null;
    }
}
