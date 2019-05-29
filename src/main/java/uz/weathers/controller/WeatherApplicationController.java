package uz.weathers.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uz.weathers.model.OpenWeatherBean;
import uz.weathers.model.WeatherEntity;
import uz.weathers.repository.WeatherLogRepository;
import uz.weathers.utility.WeatherLogUtility;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@PropertySource("classpath:openweather.properties")
public class WeatherApplicationController {
	@Value("${api-url}")
	private String OPEN_WEATHER_API_URL;
	
	@Value("${appid}")
	private String OPEN_WEATHER_APPID;

	@Value("${current-weather-by-city-name}")
	private String OPEN_WEATHER_CURRENT_BY_CITY_NAME;
	
	@Value("${appid-equals}")
	private String OPEN_WEATHER_APPID_EQUALS;

	
	@Autowired
	private WeatherLogRepository weatherLogRepository;
	
	@RequestMapping(path="/weather", method=RequestMethod.GET)
    public String weatherAll() {
		RestTemplate restTemplate = new RestTemplate();
		OpenWeatherBean openWeatherTashkent = restTemplate.getForObject(OPEN_WEATHER_API_URL+OPEN_WEATHER_CURRENT_BY_CITY_NAME+"Tashkent"+OPEN_WEATHER_APPID_EQUALS+OPEN_WEATHER_APPID, OpenWeatherBean.class);
		OpenWeatherBean openWeatherMoscow = restTemplate.getForObject(OPEN_WEATHER_API_URL+OPEN_WEATHER_CURRENT_BY_CITY_NAME+"Moscow"+OPEN_WEATHER_APPID_EQUALS+OPEN_WEATHER_APPID, OpenWeatherBean.class);
		OpenWeatherBean openWeatherSaintPetersburg = restTemplate.getForObject(OPEN_WEATHER_API_URL+OPEN_WEATHER_CURRENT_BY_CITY_NAME+"Saint+Petersburg"+OPEN_WEATHER_APPID_EQUALS+OPEN_WEATHER_APPID, OpenWeatherBean.class);
		OpenWeatherBean openWeatherTokio = restTemplate.getForObject(OPEN_WEATHER_API_URL+OPEN_WEATHER_CURRENT_BY_CITY_NAME+"Tokio"+OPEN_WEATHER_APPID_EQUALS+OPEN_WEATHER_APPID,OpenWeatherBean.class);
		WeatherEntity logLondon = processToSave(openWeatherTashkent);
		WeatherEntity logPrague = processToSave(openWeatherMoscow);
		WeatherEntity logSanFrancisco = processToSave(openWeatherSaintPetersburg);
		WeatherEntity logTokio = processToSave(openWeatherTokio);
		ObjectMapper mapper = new ObjectMapper();
		WeatherEntity[] weatherArray = {logLondon,logPrague,logSanFrancisco,logTokio};
		try {
			return mapper.writeValueAsString(weatherArray);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return "";
    }
	
	private WeatherEntity processToSave(OpenWeatherBean openWeatherBean) {
				WeatherEntity log = WeatherLogUtility.generateWeatherLog(openWeatherBean);
				System.out.println("SAVING");
				weatherLogRepository.save(log);
		return log;
	}
	
}
