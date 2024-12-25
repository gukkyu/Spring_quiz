package com.quiz.weather;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather.bo.WeatherBO;
import com.quiz.weather.domain.Weather;

@Controller
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherBO weatherBO;
	
	@GetMapping("/weather-list-view")
	public String weatherListView(
			Model model) {
		List<Weather> weather =  weatherBO.getWeather();
		
		model.addAttribute("weather", weather);
		
		return "weather/weather-list-view";
	}
	
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		
		return "weather/add-weather-view";
	}
	
	@PostMapping("/add-weather")
	public String addWeather(
			@DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("date") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		weatherBO.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		return "redirect:weather-list-view";
	}
}
