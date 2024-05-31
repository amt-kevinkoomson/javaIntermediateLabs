package WeekTwo.BehaviorialPatterns;

public interface Publisher {
    public void subscribe(Location location, ObserverDesign.WeatherListener listener);
    public void unsubscribe(Location location, ObserverDesign.WeatherListener listener);
    public void notify(String message, Location location);
    public void notify(String message);
}
