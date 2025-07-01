package br.ufscar.pooa.cinema_api.application.services.notification.observers;

import br.ufscar.pooa.cinema_api.domain.notification.Observer;
import br.ufscar.pooa.cinema_api.domain.notification.NotificationEvent;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class EmailNotificationObserver implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationObserver.class);

    @Override
    public void update(NotificationEvent event) {
        sendEmailNotification(event);
    }

    private void sendEmailNotification(NotificationEvent event) {
        String clientEmail = event.getClient().getEmail();
        String message = event.getMessage();

        logger.info("Enviando email para {}: {}", clientEmail, message);

        // Aqui a lógica real de envio
        // usando um serviço como JavaMail, SendGrid, etc.
    }
}