package repositories;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import reports.CurrentWeatherReport;
import request.WeatherRequest;

public class CurrentWeatherRepository extends Repository {
    public CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("q", request.getCity() + "," + request.getCode());
        params.put("units", request.getUnits());

        String response = this.readUrl("/find", params);

        return new CurrentWeatherReport(new JSONObject(response));
    }
}