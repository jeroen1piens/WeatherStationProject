package displaydevices;
import weatherdata.WeatherDataObject;

import java.util.ArrayList;

public class WeatherStatsDisplay implements Observer, DisplayElement {

    private boolean firstUpdate = true;
    private int avgTemperature;
    private int minTemperature;
    private int maxTemperature;
    private WeatherDataObject weatherDataObject;
    private ArrayList<Integer> registeredTemperatures = new ArrayList<>();

    public WeatherStatsDisplay(WeatherDataObject weatherDataObject) {
        this.weatherDataObject = weatherDataObject;
        weatherDataObject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("Weather stats:\n\n" +
                        "Average temperature: %d°C\n" +
                        "Minimum temperature: %d°C.\n" +
                        "Maximum temperature: %d°C\n\n\n", avgTemperature, minTemperature, maxTemperature);
    }

    @Override
    public void update() {
        int currentTemperature = (int) weatherDataObject.getTemperature();

        registeredTemperatures.add(currentTemperature);
        int sumTemperatures = 0;
        int countTemperatures = 0;
        for (int temperature : registeredTemperatures) {
            sumTemperatures += temperature;
            countTemperatures++;
        }
        avgTemperature = sumTemperatures/countTemperatures;

        if (firstUpdate) {
            minTemperature = currentTemperature;
            maxTemperature = currentTemperature;
            firstUpdate = false;
        }
        else {
            if (minTemperature > currentTemperature) {
                minTemperature = currentTemperature;
            }
            if (maxTemperature < currentTemperature) {
                maxTemperature = currentTemperature;
            }
        }
    }
}
