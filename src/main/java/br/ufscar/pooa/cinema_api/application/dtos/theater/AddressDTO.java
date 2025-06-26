package br.ufscar.pooa.cinema_api.application.dtos.theater;

import br.ufscar.pooa.cinema_api.domain.Address;

public record AddressDTO(
        String zipCode,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        String country
) {
    public static AddressDTO fromDomain(Address address) {
        if (address == null) return null;
        return new AddressDTO(
                address.getZipCode(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }
}
