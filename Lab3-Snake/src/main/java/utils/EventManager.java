package utils;

import java.util.*;

public class EventManager {
    protected Map<String, List<Listener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            listeners.put(operation, new ArrayList<>());
        }
    }
    public void subscribe(String eventType, Listener listener) {
        List<Listener> users = listeners.get(eventType);
        users.add(listener);
    }
    public void unsubscribe(String eventType, Listener listener) {
        List<Listener> users = listeners.get(eventType);
        users.remove(listener);
    }
    public void notify(String eventType) {
        List<Listener> eventListeners = listeners.get(eventType);
        for (Listener listener : eventListeners) {
            listener.handleEvent(eventType);
        }
    }
}
