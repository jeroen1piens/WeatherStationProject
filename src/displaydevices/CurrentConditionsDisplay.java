package displaydevices;
import weatherdata.WeatherDataObject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private double temperature;
    private double humidity;
    private WeatherDataObject weatherDataObject;


    public CurrentConditionsDisplay(WeatherDataObject weatherDataObject) {
        this.weatherDataObject = weatherDataObject;
        weatherDataObject.registerObserver(this);
    }

    @Override
    public void update() {
        temperature = weatherDataObject.getTemperature();
        humidity = weatherDataObject.getHumidity();
    }

    @Override
    public void display() {
        System.out.printf("The current temperature is %f ° Celsius and the humidity is %f percent.", temperature, humidity);
    }

}
