package br.ufscar.pooa.cinema_api.adapters.out.persistence.mappers;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.SessionEntity;
import br.ufscar.pooa.cinema_api.domain.Session;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {MovieMapper.class,
                RoomMapper.class,
                AddressMapper.class})
public interface SessionMapper {

    Session toDomain(SessionEntity entity);
}