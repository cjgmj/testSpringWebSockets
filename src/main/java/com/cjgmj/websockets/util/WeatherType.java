package com.cjgmj.websockets.util;

public enum WeatherType {

	SUNNY("Sunny", "The sun is shinnning"), RAINY("Rainy", "The rain is soaking me"),
	WINDY("Windy", "Strong guts of wind");

	private String name;
	private String description;

	private WeatherType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

}
