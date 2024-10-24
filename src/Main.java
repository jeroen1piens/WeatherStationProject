
import displaydevices.CurrentConditionsDisplay;
import displaydevices.WeatherStatsDisplay;
import weatherdata.WeatherDataObject;

public class Main {
    public static void main(String[] args) {

        WeatherDataObject weatherDataObject = new WeatherDataObject();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherDataObject);
        WeatherStatsDisplay weatherStatsDisplay = new WeatherStatsDisplay(weatherDataObject);

        currentConditionsDisplay.display();

        weatherDataObject.setState(20, 10, 1000);

        currentConditionsDisplay.display();

        weatherDataObject.setState(25, 30, 1030);

        currentConditionsDisplay.display();

        weatherDataObject.setState(30, 20, 1010);

        currentConditionsDisplay.display();
        weatherStatsDisplay.display();


    }
}