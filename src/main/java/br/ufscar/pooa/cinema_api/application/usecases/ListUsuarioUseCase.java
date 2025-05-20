package br.ufscar.pooa.cinema_api.application.usecases;

import br.ufscar.pooa.cinema_api.application.dtos.request.FindByIdUsuarioRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.response.UsuarioResponseDTO;
import br.ufscar.pooa.cinema_api.application.exceptions.ResourceNotExistsException;
import br.ufscar.pooa.cinema_api.application.ports.in.IListUsuarioUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.IUsuarioRepository;
import br.ufscar.pooa.cinema_api.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListUsuarioUseCase implements IListUsuarioUseCase {
    private final IUsuarioRepository usuarioRepository;

    public ListUsuarioUseCase(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioResponseDTO> list() {
        List<Usuario> usuarios = usuarioRepository.list();

        if(usuarios.isEmpty()) {
            throw new ResourceNotExistsException("Nenhum usuário encontrado");
        }

        return usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail(),
                        usuario.getSenha()))
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO findById(FindByIdUsuarioRequestDTO requestDTO) {
        Optional<Usuario> usuario = usuarioRepository.findById(requestDTO.id());

        if(usuario.isEmpty()) {
            throw new ResourceNotExistsException("Usuário não encontrado com ID: " + requestDTO.id());
        }

        return new UsuarioResponseDTO(
                usuario.get().getId(),
                usuario.get().getNome(),
                usuario.get().getEmail(),
                usuario.get().getSenha());
    }
}
