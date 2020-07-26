package com.cjgmj.websockets.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.cjgmj.websockets.util.WeatherType;

public class WeatherInfo {

	private WeatherType type;
	private LocalDateTime time;
	private String localDateTimeStr;
	private String place;

	public WeatherInfo() {
	}

	public WeatherInfo(WeatherType type, LocalDateTime time, String place) {
		this.type = type;
		this.time = time;
		this.place = place;
	}

	public WeatherType getType() {
		return this.type;
	}

	public void setType(WeatherType type) {
		this.type = type;
	}

	public LocalDateTime getTime() {
		return this.time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getLocalDateTimeStr() {
		return this.time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	}

	public void setLocalDateTimeStr(String localDateTimeStr) {
		this.localDateTimeStr = localDateTimeStr;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
