package br.ufscar.pooa.cinema_api.infrastructure.persistence.mapper;

import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.infrastructure.persistence.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface UsuarioEntityMapper {
    UsuarioEntity toEntity(Usuario usuario);

    Usuario toDomain(UsuarioEntity usuarioEntity);
}
