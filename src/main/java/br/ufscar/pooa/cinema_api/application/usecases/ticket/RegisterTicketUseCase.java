package br.ufscar.pooa.cinema_api.application.usecases.ticket;

import br.ufscar.pooa.cinema_api.adapters.out.payment.PaymentStrategyFactory;
import br.ufscar.pooa.cinema_api.application.dtos.ticket.RegisterTicketRequestDTO;
import br.ufscar.pooa.cinema_api.application.dtos.ticket.TicketResponseDTO;
import br.ufscar.pooa.cinema_api.application.exceptions.BadRequestException;
import br.ufscar.pooa.cinema_api.application.exceptions.ResourceNotFoundException;
import br.ufscar.pooa.cinema_api.application.ports.in.IRegisterTicketUseCase;
import br.ufscar.pooa.cinema_api.application.ports.out.mapper.IObjectMapper;
import br.ufscar.pooa.cinema_api.application.ports.out.payment.IPaymentStrategy;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.IClientRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.ISeatRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.ISessionRepository;
import br.ufscar.pooa.cinema_api.application.ports.out.repository.ITicketRepository;
import br.ufscar.pooa.cinema_api.domain.Client;
import br.ufscar.pooa.cinema_api.domain.Seat;
import br.ufscar.pooa.cinema_api.domain.Session;
import br.ufscar.pooa.cinema_api.domain.Ticket;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class RegisterTicketUseCase implements IRegisterTicketUseCase {

    private final ITicketRepository ticketRepository;
    private final ISessionRepository sessionRepository;
    private final ISeatRepository seatRepository;
    private final IClientRepository clientRepository;
    private final PaymentStrategyFactory paymentStrategyFactory;
    private final IObjectMapper objectMapper;

    public RegisterTicketUseCase(ITicketRepository ticketRepository,
                                 ISessionRepository sessionRepository,
                                 ISeatRepository seatRepository,
                                 IClientRepository clientRepository,
                                 PaymentStrategyFactory paymentStrategyFactory,
                                 IObjectMapper objectMapper) {
        this.ticketRepository = ticketRepository;
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
        this.clientRepository = clientRepository;
        this.paymentStrategyFactory = paymentStrategyFactory;
        this.objectMapper = objectMapper;
    }

    @Override
    public TicketResponseDTO execute(RegisterTicketRequestDTO requestDTO) {
        Session session = sessionRepository.findById(requestDTO.getSessionId())
                .orElseThrow(() -> new ResourceNotFoundException("Sessão", "id", requestDTO.getSessionId().toString()));

        Seat seat = seatRepository.findById(requestDTO.getSeatId())
                .orElseThrow(() -> new ResourceNotFoundException("Assento", "id", requestDTO.getSeatId().toString()));

        Client client = clientRepository.findById(requestDTO.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", requestDTO.getClientId().toString()));

        IPaymentStrategy paymentStrategy = paymentStrategyFactory.getStrategy(requestDTO.getPaymentMethod())
                .orElseThrow(() -> new IllegalArgumentException("Método de pagamento inválido ou não suportado."));

        System.out.println(session.getTickets());

        if (!session.isSeatAvailable(seat)) {
            throw new BadRequestException("Assento indisponível.");
        }

        boolean paymentSuccessful = paymentStrategy.pay(requestDTO.getPriceInCentsClient());
        if (!paymentSuccessful) {
            throw new RuntimeException("Falha ao processar o pagamento.");
        }

        Ticket newTicket = new Ticket();
        newTicket.setClient(client);
        newTicket.setSession(session);
        newTicket.setSeat(seat);
        newTicket.setPaymentMethod(requestDTO.getPaymentMethod());
        newTicket.setPriceInCents(requestDTO.getPriceInCentsClient());
        newTicket.setPaymentDate(Instant.now());

        Ticket savedTicket = ticketRepository.save(newTicket);

        System.out.println(savedTicket.getSession());

        return objectMapper.parseObject(savedTicket, TicketResponseDTO.class);
    }
}