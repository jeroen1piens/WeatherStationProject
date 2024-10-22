package weatherdata;
import displaydevices.DisplayElement;
import displaydevices.Observer;
import java.util.ArrayList;
import java.lang.Override;

public class WeatherDataObject implements Subject {
    private double temperature;
    private double humidity;
    private double pressure;

    private ArrayList<Observer> observers = new ArrayList<>();

    public WeatherDataObject() {
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setState(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

}
