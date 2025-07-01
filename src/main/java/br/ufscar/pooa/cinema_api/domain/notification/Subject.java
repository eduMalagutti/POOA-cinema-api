package br.ufscar.pooa.cinema_api.domain.notification;

import java.util.List;

public interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(NotificationEvent event);
    List<Observer> getObservers();
}