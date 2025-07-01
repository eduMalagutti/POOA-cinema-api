package br.ufscar.pooa.cinema_api.application.services.notification;

import br.ufscar.pooa.cinema_api.application.ports.out.repository.ISessionRepository;
import br.ufscar.pooa.cinema_api.domain.Session;
import br.ufscar.pooa.cinema_api.domain.Ticket;
import br.ufscar.pooa.cinema_api.domain.notification.NotificationEvent;
import br.ufscar.pooa.cinema_api.domain.notification.NotificationType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SessionReminderService {
    private final ISessionRepository sessionRepository;
    private final SessionNotificationManager notificationManager;

    public SessionReminderService(ISessionRepository sessionRepository,
                                  SessionNotificationManager notificationManager) {
        this.sessionRepository = sessionRepository;
        this.notificationManager = notificationManager;
    }

    @Scheduled(fixedRate = 300000) // Executa a cada 5 minutos
    public void checkUpcomingSessions() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneHourLater = now.plusHours(1);

        // Busca sessões que começam em aproximadamente 1 hora
        List<Session> upcomingSessions = sessionRepository
                .findSessionsStartingBetween(now.plusMinutes(55), oneHourLater.plusMinutes(5));

        for (Session session : upcomingSessions) {
            sendSessionReminders(session);
        }
    }

    private void sendSessionReminders(Session session) {
        List<Ticket> tickets = session.getTickets();

        for (Ticket ticket : tickets) {
            if (ticket.getClient() != null) {
                String message = createReminderMessage(session);
                NotificationEvent event = new NotificationEvent(
                        NotificationType.SESSION_REMINDER,
                        message,
                        session,
                        ticket.getClient()
                );

                notificationManager.notifyObservers(event);
            }
        }
    }

    private String createReminderMessage(Session session) {
        return String.format(
                "Lembrete: Sua sessão do filme '%s' começará em 1 hora (%s). " +
                        "Sala: %s. Não se esqueça!",
                session.getMovie().getTitle(),
                session.getDate().toString(),
                session.getRoom().getName()
        );
    }
}