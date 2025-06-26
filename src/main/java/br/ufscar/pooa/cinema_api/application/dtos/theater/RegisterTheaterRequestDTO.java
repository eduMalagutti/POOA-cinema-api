package br.ufscar.pooa.cinema_api.application.dtos.theater;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record RegisterTheaterRequestDTO(
        @NotBlank
        String name,

        String logoUrl,

        AddressDTO address,

        @NotEmpty
        List<Long> managerIds
) {

}
