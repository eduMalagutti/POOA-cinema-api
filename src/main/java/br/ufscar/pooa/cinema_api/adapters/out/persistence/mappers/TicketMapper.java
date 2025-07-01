package br.ufscar.pooa.cinema_api.adapters.out.persistence.mappers;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.TicketEntity;
import br.ufscar.pooa.cinema_api.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "session", ignore = true)
    @Mapping(target = "seat", ignore = true)
    Ticket toDomain(TicketEntity entity);
}