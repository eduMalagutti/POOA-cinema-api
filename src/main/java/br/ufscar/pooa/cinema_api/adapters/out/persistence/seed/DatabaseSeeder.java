package br.ufscar.pooa.cinema_api.adapters.out.persistence.seed;

import br.ufscar.pooa.cinema_api.application.ports.out.repository.*;
import br.ufscar.pooa.cinema_api.domain.*;
import br.ufscar.pooa.cinema_api.domain.enums.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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

        // 1. Theater
        Address address = new Address("13560-000", "Rua do Teste", "123", null, "São Carlos", "Centro", "SP", "Brasil");
        Theater theater = new Theater("Cine Teste", "http://logo.url/logo.png", new ArrayList<>(), address, new ArrayList<>(), new ArrayList<>());
        Theater savedTheater = theaterRepository.save(theater);

        // 2. Client
        Client client = new Client("Cliente de Teste", "cliente@teste.com", passwordEncoder.encode("123456"), savedTheater, "123.456.789-00", Gender.MALE, LocalDateTime.now().minusYears(25), new ArrayList<>(), Role.CLIENT);
        Client savedClient = clientRepository.save(client);

        // 3. Room
        Room room = new Room(null, "Sala Teste 1", RoomType.STANDARD, savedTheater, new ArrayList<>(), new ArrayList<>());
        Room savedRoom = roomRepository.save(room);

        // 4. Row
        Row row = new Row('A', savedRoom, new ArrayList<>());
        Row savedRow = rowRepository.save(row);

        // 5. Seat
        Seat seat = new Seat('1', savedRow, new ArrayList<>(), SeatType.STANDARD);
        Seat savedSeat = seatRepository.save(seat);

        // 6. Genre
        Genre genre = new Genre(null, "Ação", new ArrayList<>());
        Genre savedGenre = genreRepository.save(genre);

        // 7. Movie
        List<Genre> genres = new ArrayList<>();
        genres.add(savedGenre);
        Movie movie = new Movie(AgeRating.FOURTEEN_YEARS, genres, savedTheater, new ArrayList<>(), 7500, "http://trailer.url/trailer.mp4", "http://cover.url/cover.jpg", "Um filme de teste para uma API incrível.", "Filme de Teste");
        Movie savedMovie = movieRepository.save(movie);

        // 8. Session
        Session session = new Session(Format.TWO_D, LocalDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(1).plusMinutes(1), Subtitle.DUBBED, 3500, savedRoom, savedMovie, new ArrayList<>());
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