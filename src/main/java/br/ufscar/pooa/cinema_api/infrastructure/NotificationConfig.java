package br.ufscar.pooa.cinema_api.infrastructure;

import br.ufscar.pooa.cinema_api.application.services.notification.SessionNotificationManager;
import br.ufscar.pooa.cinema_api.application.services.notification.observers.EmailNotificationObserver;
import br.ufscar.pooa.cinema_api.application.services.notification.observers.SMSNotificationObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class NotificationConfig {

    @Bean
    public SessionNotificationManager sessionNotificationManager(
            EmailNotificationObserver emailObserver,
            SMSNotificationObserver smsObserver) {

        SessionNotificationManager manager = new SessionNotificationManager();
        manager.subscribe(emailObserver);
        manager.subscribe(smsObserver);

        return manager;
    }
}