package br.ufscar.pooa.cinema_api.application.dtos.theater;

import java.util.List;

public record TheaterResponseDTO(
        Long id,
        String name,
        String logoUrl,
        AddressDTO address,
        List<Long> roomIds,
        List<Long> managerIds,
        List<Long> movieIds
) {
}
