package displaydevices;
import weatherdata.WeatherDataObject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private int temperature;
    private int humidity;
    private WeatherDataObject weatherDataObject;


    public CurrentConditionsDisplay(WeatherDataObject weatherDataObject) {
        this.weatherDataObject = weatherDataObject;
        weatherDataObject.registerObserver(this);
    }

    @Override
    public void update() {
        temperature = (int) Math.round(weatherDataObject.getTemperature());
        humidity = (int) Math.round(weatherDataObject.getHumidity());
    }

    @Override
    public void display() {
        System.out.printf("Current weather conditions:\n\n" +
                "Temperature: %d°C\n" +
                "Humidity: %d%%.\n\n\n", temperature, humidity);
    }

}
