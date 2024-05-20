package WeekTwo.BehaviorialPatterns;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature, float humidity, float pressure);
}

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject class representing the Weather Station
class WeatherStation implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // Method to update weather data and notify observers
    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }
}

// Concrete Observer class representing a Display
class Display implements Observer {
    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("Display: Temperature = " + temperature + "°C, Humidity = " + humidity + "%, Pressure = " + pressure + "hPa");
    }
}

// Client code to test the Observer pattern
public class ObserverClient {
    public static void main(String[] args) {
        // Create a WeatherStation
        WeatherStation weatherStation = new WeatherStation();

        // Create displays
        Display display1 = new Display();
        Display display2 = new Display();

        // Register displays as observers
        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        // Simulate weather data updates
        weatherStation.setWeatherData(25.5f, 60.2f, 1013.25f);
    }
}

