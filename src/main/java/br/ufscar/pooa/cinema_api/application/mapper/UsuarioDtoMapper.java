package br.ufscar.pooa.cinema_api.application.mapper;

import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import br.ufscar.pooa.cinema_api.application.dtos.request.RegisterUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

@Primary
@Mapper(componentModel = "spring")
public interface UsuarioDtoMapper {
    Usuario toDomain(RegisterUsuarioRequestDTO registerUsuarioRequestDTO);

    UsuarioResponseDTO toResponseDTO(Usuario usuario);
}
