package com.cjgmj.websockets.domain;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cjgmj.websockets.model.WeatherInfo;
import com.cjgmj.websockets.util.WeatherType;

@Component
public class WeatherData {

	private Map<String, WeatherInfo> weatherData;

	public WeatherData() {
		this.weatherData = new HashMap<>();
		this.weatherData.put("Seville",
				new WeatherInfo(WeatherType.SUNNY, LocalDateTime.of(2020, Month.JULY, 26, 13, 30), "Seville"));
		this.weatherData.put("Berlin",
				new WeatherInfo(WeatherType.RAINY, LocalDateTime.of(2020, Month.JULY, 26, 13, 30), "Berlin"));
		this.weatherData.put("London",
				new WeatherInfo(WeatherType.RAINY, LocalDateTime.of(2020, Month.JULY, 26, 13, 30), "London"));
	}

	public WeatherInfo getWeatherFrom(String place) {
		return this.weatherData.get(place);
	}

	public List<WeatherInfo> getAllWeather() {
		return this.weatherData.keySet().stream().map(key -> this.weatherData.get(key)).collect(Collectors.toList());
	}

}
