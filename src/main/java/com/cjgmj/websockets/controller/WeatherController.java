package com.cjgmj.websockets.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import com.cjgmj.websockets.domain.WeatherData;
import com.cjgmj.websockets.model.PlaceInfo;
import com.cjgmj.websockets.model.WeatherInfo;

@Controller
@EnableScheduling
public class WeatherController {

	private static Logger logger = LoggerFactory.getLogger(WeatherController.class);

	@Autowired
	private WeatherData weatherData;

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/weather")
	@SendTo("/topic/weatherinfo")
	public WeatherInfo getWeatherInfo(PlaceInfo place) {
		WeatherInfo wInfo = new WeatherInfo();
		try {
			logger.info("Obteniendo datos de " + place.getPlace());

			Thread.sleep(1000);

			wInfo = this.weatherData.getWeatherFrom(place.getPlace());

			logger.info("Datos de " + place.getPlace());

		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		return wInfo;
	}

//	@Scheduled(fixedRate = 2000)
	public void runWInfo() {
		this.template.convertAndSend("/topic/weatherinfo", this.weatherData.getWeatherFrom("Seville"));
	}

}
