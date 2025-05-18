package br.ufscar.pooa.cinema_api.infrastructure.mapper;

import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.infrastructure.persistence.entities.UsuarioEntity;
import br.ufscar.pooa.cinema_api.presentation.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.presentation.dtos.response.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioEntity toEntity(Usuario usuario);

    Usuario toDomain(UsuarioEntity usuarioEntity);

    Usuario toDomain(RegisterUsuarioRequestDTO registerUsuarioRequestDTO);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);
}
