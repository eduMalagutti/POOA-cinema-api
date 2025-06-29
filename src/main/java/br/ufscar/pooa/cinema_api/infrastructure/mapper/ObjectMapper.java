package br.ufscar.pooa.cinema_api.infrastructure.mapper;

import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ObjectMapper implements IObjectMapper {

    private final ModelMapper modelMapper;

    public ObjectMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <O, D> D parseObject(O origin, Class<D> destination) {
        if (origin == null) {
            return null;
        }

        return modelMapper.map(origin, destination);
    }

    @Override
    public <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        if (origin == null) {
            return null;
        }

        return origin.stream()
                .map(element -> parseObject(element, destination))
                .collect(Collectors.toList());
    }
}
