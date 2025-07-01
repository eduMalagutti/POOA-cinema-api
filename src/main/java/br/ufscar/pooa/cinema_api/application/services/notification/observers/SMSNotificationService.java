package br.ufscar.pooa.cinema_api.application.services.notification.observers;

import br.ufscar.pooa.cinema_api.domain.notification.Observer;
import br.ufscar.pooa.cinema_api.domain.notification.NotificationEvent;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class SMSNotificationService implements Observer {
    private static final Logger logger = LoggerFactory.getLogger(SMSNotificationService.class);

    @Override
    public void update(NotificationEvent event) {
        sendSMSNotification(event);
    }

    private void sendSMSNotification(NotificationEvent event) {
        String message = event.getMessage();

        logger.info("Enviando SMS para cliente {}: {}",
                event.getClient().getId(), message);

        // Aqui a lógica real de envio de SMS
    }
}