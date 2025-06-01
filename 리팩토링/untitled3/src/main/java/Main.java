class Emailer implements Alerter {
    @Override
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}

class Phone implements Alerter {
    public String generateWeatherAlert(String weatherConditions) {
        String alert = "It is " + weatherConditions;
        return alert;
    }
}

class WeatherTracker {
    String currentConditions;

    public WeatherTracker() {
    }

    public void setCurrentConditions(String weatherDescription) {
        this.currentConditions = weatherDescription;
        if (weatherDescription == "rainy") {
            Alerter alert = new Phone();
            System.out.print(alert.generateWeatherAlert(weatherDescription));
        }
        if (weatherDescription == "sunny") {
            Alerter alert = new Emailer();
            System.out.print(alert.generateWeatherAlert(weatherDescription));
        }
    }
}

class Main {
    private static void main(String[] args) {

    }
}