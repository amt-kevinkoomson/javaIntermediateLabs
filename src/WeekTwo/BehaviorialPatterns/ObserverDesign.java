package WeekTwo.BehaviorialPatterns;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class ObserverDesign {
    /*
     * Listeners/subscribers/observers - implements update method
     * Weather - Subject
     * Publishers - service that maintains a list of listeners. implements subscribe, unsubscribe, and notify methods
     *  notify method calls update method on all listeners
     *  subscribe adds a listener to a list, subscribed to a certain event
     *  unsubscribe removes a listener to a list, subscribed to a certain event
     *
     * Locations - enum - event
     */
    @Data
    public static class WeatherPublisher implements Publisher {
        private HashMap<Location, List<WeatherListener>> locationListeners;
        public WeatherPublisher(){
            this.locationListeners = new HashMap<>();
        }

        @Override
        public void subscribe(Location location, WeatherListener listener) throws  IllegalArgumentException {
            /*
             * adds a listener to a location (event)
             */
            List<WeatherListener> listeners = locationListeners.get(location);
            if (listeners == null) listeners = new ArrayList<>();
            if(listeners.contains(listener)) throw new IllegalArgumentException("Listener already exists");
            listeners.add(listener);
            locationListeners.put(location, listeners);
            System.out.println("Listener: " + listener.email + " subscribed to location: " + location);
        }

        @Override
        public void unsubscribe(Location location, WeatherListener listener) throws  IllegalArgumentException {
            List<WeatherListener> listeners = locationListeners.get(location);
            if (listeners == null) listeners = new ArrayList<>();
            if(!listeners.contains(listener)) throw new IllegalArgumentException("Listener does not exist");
            listeners.remove(listener);
            locationListeners.put(location, listeners);
            System.out.println("Listener: " + listener.email + " unsubscribed to location: " + location);
        }

        @Override
        public void notify(String message, Location location) {
            List<WeatherListener> listeners = locationListeners.get(location);
            if (listeners == null) {
                System.out.println("No listeners for location: " + location);
                return;
            }
            for (WeatherListener listener : listeners) {
                try{
                    Thread.sleep(1_000);
                    System.out.println("Email sent to listener:  " + listener.email);
                } catch(InterruptedException e) {
                    System.out.println("Failed to send email to listener: " + listener.email);
                }
            }
            System.out.println("All listeners for location : " + location + " notified");
        }

        @Override
        public void notify(String message) {
            Set<WeatherListener> listenersSet = locationListeners.values().stream().flatMap(List::stream).collect(Collectors.toSet());
            listenersSet.forEach(i-> i.message(message));
        }
    }

        public record WeatherListener(String name, String email) implements Listener {

        @Override
            public void update() {
                System.out.println("Updating weather for " + name + ", Email sent to: " + email);
            }

            @Override
            public void message(String message) {
                System.out.println("Message: \"" + message + "\" sent to listener: " + email);

            }
        }

    public static void main(String[] args) {
        WeatherPublisher publisher = new WeatherPublisher();
        publisher.subscribe(Location.TAKORADI, new WeatherListener("Kevin", "kevin@mail.com"));
        publisher.subscribe(Location.ACCRA, new WeatherListener("Yaa", "yaa@mail.com"));
        publisher.subscribe(Location.KIGALI, new WeatherListener("Joe", "joe@mail.com"));
        publisher.subscribe(Location.BERLIN, new WeatherListener("Nana", "nana@mail.com"));
        publisher.subscribe(Location.TAKORADI, new WeatherListener("Sharon", "sharon@mail.com"));
        publisher.subscribe(Location.ACCRA, new WeatherListener("Christabel", "christabel@mail.com"));
        publisher.subscribe(Location.KIGALI, new WeatherListener("Nessa", "nessa@mail.com"));
        publisher.subscribe(Location.BERLIN, new WeatherListener("Melissa", "melissa@mail.com"));

        publisher.notify("Weather has changed", Location.ACCRA);
        publisher.notify("Weather has changed", Location.TAKORADI);
        publisher.notify("Weather has changed", Location.KUMASI);

        publisher.notify("There's a new product");

    }

}
