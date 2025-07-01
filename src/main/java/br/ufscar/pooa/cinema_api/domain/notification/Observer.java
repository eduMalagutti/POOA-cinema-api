package br.ufscar.pooa.cinema_api.domain.notification;

public interface Observer {
    void update(NotificationEvent event);
}