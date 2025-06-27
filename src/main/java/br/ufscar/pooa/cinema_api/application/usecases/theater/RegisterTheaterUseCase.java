package br.ufscar.pooa.cinema_api.application.usecases.theater;

            import br.ufscar.pooa.cinema_api.application.dtos.theater.RegisterTheaterRequestDTO;
            import br.ufscar.pooa.cinema_api.application.dtos.theater.TheaterResponseDTO;
            import br.ufscar.pooa.cinema_api.application.exceptions.ResourceAlreadyExistsException;
            import br.ufscar.pooa.cinema_api.application.exceptions.ResourceNotFoundException;
            import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterTheaterUseCase;
            import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
            import br.ufscar.pooa.cinema_api.application.ports.out.repository.IAddressRepository;
            import br.ufscar.pooa.cinema_api.application.ports.out.repository.ITheaterRepository;
            import br.ufscar.pooa.cinema_api.application.ports.out.repository.IUserRepository;
            import br.ufscar.pooa.cinema_api.domain.Theater;
            import br.ufscar.pooa.cinema_api.domain.User;
            import br.ufscar.pooa.cinema_api.domain.enums.Role;
            import org.springframework.stereotype.Service;
            import org.springframework.transaction.annotation.Transactional;

            @Service
            public class RegisterTheaterUseCase implements IRegisterTheaterUseCase {
                private final ITheaterRepository theaterRepository;
                private final IObjectMapper objectMapper;
                private final IAddressRepository addressRepository;
                private final IUserRepository userRepository;

                public RegisterTheaterUseCase(ITheaterRepository theaterRepository, IObjectMapper objectMapper,
                                              IAddressRepository addressRepository, IUserRepository userRepository) {
                    this.theaterRepository = theaterRepository;
                    this.objectMapper = objectMapper;
                    this.addressRepository = addressRepository;
                    this.userRepository = userRepository;
                }

                @Override
                @Transactional
                public TheaterResponseDTO execute(RegisterTheaterRequestDTO requestDTO) {
                    theaterRepository.findByName(requestDTO.getName()).ifPresent(t -> {
                        throw new ResourceAlreadyExistsException("Theater", "name", requestDTO.getName());
                    });
                    addressRepository.findByStreetAndNumber(
                            requestDTO.getAddress().getStreet(), requestDTO.getAddress().getNumber()
                    ).ifPresent(a -> {
                        throw new ResourceAlreadyExistsException("Address", "street and number",
                                requestDTO.getAddress().getStreet() + " " + requestDTO.getAddress().getNumber());
                    });

                    if (requestDTO.getManagerIds() == null || requestDTO.getManagerIds().isEmpty()) {
                        throw new IllegalArgumentException("At least one manager ID must be provided.");
                    }

                    Theater newTheater = objectMapper.parseObject(requestDTO, Theater.class);
                    for (Long managerId : requestDTO.getManagerIds()) {
                        User userFound = userRepository.findById(managerId)
                                .orElseThrow(() -> new ResourceNotFoundException("User", "id", String.valueOf(managerId)));
                        if (userFound.getRole() != Role.MANAGER) {
                            throw new IllegalArgumentException("User with id " + managerId + " is not a manager.");
                        }
                        if (userFound.getTheater() != null) {
                            throw new IllegalArgumentException("User with id " + managerId + " is already assigned to another theater.");
                        }
                        userFound.setTheater(newTheater);
                        newTheater.getManagers().add(userFound);
                    }

                    Theater savedTheater = theaterRepository.save(newTheater);
                    return objectMapper.parseObject(savedTheater, TheaterResponseDTO.class);
                }
            }