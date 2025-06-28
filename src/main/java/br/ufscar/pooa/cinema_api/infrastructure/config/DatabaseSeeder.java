package br.ufscar.pooa.cinema_api.infrastructure.config;

import br.ufscar.pooa.cinema_api.application.ports.out.repository.*;
import br.ufscar.pooa.cinema_api.domain.*;
import br.ufscar.pooa.cinema_api.domain.enums.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

    private final ITheaterRepository theaterRepository;
    private final IClientRepository clientRepository;
    private final IGenreRepository genreRepository;
    private final IMovieRepository movieRepository;
    private final IRoomRepository roomRepository;
    private final IRowRepository rowRepository;
    private final ISeatRepository seatRepository;
    private final ISessionRepository sessionRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseSeeder(ITheaterRepository theaterRepository, IClientRepository clientRepository,
                          IGenreRepository genreRepository, IMovieRepository movieRepository,
                          IRoomRepository roomRepository, IRowRepository rowRepository,
                          ISeatRepository seatRepository, ISessionRepository sessionRepository,
                          PasswordEncoder passwordEncoder) {
        this.theaterRepository = theaterRepository;
        this.clientRepository = clientRepository;
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
        this.rowRepository = rowRepository;
        this.seatRepository = seatRepository;
        this.sessionRepository = sessionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (theaterRepository.count() > 0) {
            System.out.println("Banco de dados já populado. Seeding não executado.");
            return;
        }

        System.out.println("Iniciando seeding MÍNIMO para criação de Ticket...");

        // 1. Criar o Cinema (Theater)
        Address address = new Address("13560-000", "Rua do Teste", "123", null, "São Carlos", "Centro", "SP", "Brasil");
        Theater theater = new Theater("Cine Teste", "http://logo.url/logo.png", new ArrayList<>(), address, new ArrayList<>(), new ArrayList<>());
        Theater savedTheater = theaterRepository.save(theater);

        // 2. Criar o Cliente (Client)
        Client client = new Client("Cliente de Teste", "cliente@teste.com", passwordEncoder.encode("123456"), savedTheater, "123.456.789-00", Gender.MALE, LocalDateTime.now().minusYears(25), new ArrayList<>(), Role.CLIENT);
        Client savedClient = clientRepository.save(client);

        // ======================= INÍCIO DA CORREÇÃO =======================
        // 3. Criar a Sala, Fileira e Assento
        Room room = new Room(null, "Sala Teste 1", RoomType.STANDARD, savedTheater, new ArrayList<>(), new ArrayList<>());
        Room savedRoom = roomRepository.save(room);

        Row row = new Row('A', savedRoom, new ArrayList<>());
        // Primeiro, salve a fileira para garantir que ela exista no banco e tenha um ID.
        Row savedRow = rowRepository.save(row);

        // Agora crie o assento, passando a fileira JÁ SALVA (com ID) para ele.
        Seat seat = new Seat('1', savedRow, new ArrayList<>(), SeatType.STANDARD);
        // E salve o assento explicitamente. A variável 'savedSeat' agora terá o ID correto.
        Seat savedSeat = seatRepository.save(seat);
        // ======================== FIM DA CORREÇÃO =========================

        // 4. Criar o Gênero e o Filme
        Genre genre = new Genre(null, "Ação", new HashSet<>());
        Genre savedGenre = genreRepository.save(genre);

        Movie movie = new Movie(AgeRating.FOURTEEN_YEARS, new HashSet<>(Set.of(savedGenre)), savedTheater, new ArrayList<>(), 7500, "http://trailer.url/trailer.mp4", "http://cover.url/cover.jpg", "Um filme de teste para uma API incrível.", "Filme de Teste");
        Movie savedMovie = movieRepository.save(movie);

        // 5. Criar a Sessão
        Session session = new Session(Format.TWO_D, (int) (System.currentTimeMillis() / 1000), Subtitle.DUBBED, 3500, savedRoom, savedMovie, new ArrayList<>());
        Session savedSession = sessionRepository.save(session);

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Seeding Mínimo Finalizado!");
        System.out.println("Use os seguintes IDs para criar um Ticket no Insomnia:");
        System.out.println(">>> clientId: " + savedClient.getId());
        System.out.println(">>> sessionId: " + savedSession.getId());
        System.out.println(">>> seatId: " + savedSeat.getId());
        System.out.println("------------------------------------------------------------\n");
    }
}