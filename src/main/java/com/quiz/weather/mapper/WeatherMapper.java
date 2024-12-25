package com.quiz.weather.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weather.domain.Weather;

@Mapper
public interface WeatherMapper {
	
	public List<Weather> selectWeather();
	
	public void insertWeather(
			@Param("date") Date date,
			@Param("weather") String weather, 
			@Param("temperatures") double temperatures, 
			@Param("precipitation") double precipitation, 
			@Param("microDust") String microDust, 
			@Param("windSpeed") double windSpeed);
}
