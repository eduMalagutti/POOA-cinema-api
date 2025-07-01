package br.ufscar.pooa.cinema_api.application.services.notification;

import br.ufscar.pooa.cinema_api.domain.notification.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class SessionNotificationManager implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(NotificationEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    @Override
    public List<Observer> getObservers() {
        return List.copyOf(observers);
    }
}