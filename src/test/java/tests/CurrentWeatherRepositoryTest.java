package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import reports.CurrentWeatherReport;
import request.WeatherRequest;

class CurrentWeatherRepositoryTest {
    @Test
    void checkCurrentWeatherResponse() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", "EE", "metric");
            repositories.CurrentWeatherRepository repository = new repositories.CurrentWeatherRepository();

            CurrentWeatherReport report = repository.getCurrentWeather(request);

            assertEquals(request.getCity(), report.getCity());
            assertEquals(request.getCode(), report.getCode());
            assertNotNull(report.getCurrentTemperature());
            assertNotNull(report.getMaximumTemperature());
            assertNotNull(report.getMinimalTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}
