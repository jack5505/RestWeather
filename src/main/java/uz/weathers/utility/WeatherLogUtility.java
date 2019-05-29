package uz.weathers.utility;

import java.util.Date;
import uz.weathers.model.OpenWeatherBean;
import uz.weathers.model.WeatherEntity;

public class WeatherLogUtility {
	public static WeatherEntity generateWeatherLog(OpenWeatherBean openWeather) {
		WeatherEntity log = new WeatherEntity();
		log.setActualWeather(openWeather.getWeather()[0].getMain());
		log.setLocation(openWeather.getName());
		log.setTemperature(openWeather.getMain().getTemp()+"");
		log.setDtimeInserted(new Date());
		return log;
	}
	private static String transfer(String transferIt){
		int seconds = (int) ((Long.parseLong(transferIt)) / 1000) % 60 ;
		int minutes = (int) (((Long.parseLong(transferIt)) / (1000*60)) % 60);
		int hours   = (int) (((Long.parseLong(transferIt)) / (1000*60*60)) % 24);
		return hours+" "+minutes+" "+seconds;
	}
}
