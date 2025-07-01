package br.ufscar.pooa.cinema_api.adapters.out.persistence.mappers;

import br.ufscar.pooa.cinema_api.adapters.out.persistence.entities.RowEntity;
import br.ufscar.pooa.cinema_api.domain.Row;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RowMapper {
    
    @Mapping(target = "room", ignore = true)
    @Mapping(target = "seats", ignore = true)
    Row toDomain(RowEntity entity);
}