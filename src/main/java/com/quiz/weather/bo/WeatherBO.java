package com.quiz.weather.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weather.domain.Weather;
import com.quiz.weather.mapper.WeatherMapper;

@Service
public class WeatherBO {
	
	@Autowired
	private WeatherMapper weatherMapper;
	
	public List<Weather> getWeather() {
		return weatherMapper.selectWeather();
	}
	
	public void addWeather(Date date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		weatherMapper.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
	}
}
