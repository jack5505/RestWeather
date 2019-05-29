package uz.weathers.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherBean {
	private Weather[] weather;
	private Main main;
	private String name;
	private Main.Sys sys;
	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Main.Sys getSys() {
		return sys;
	}

	public void setSys(Main.Sys sys) {
		this.sys = sys;
	}

	@Override
	public String toString() {
		return "OpenWeatherBean [weather=" + weather + ", main=" + main + ", name=" + name+"]";
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Weather {
		private int id;
		private String main;
		private String description;
		private String icon;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMain() {
			return main;
		}
		public void setMain(String main) {
			this.main = main;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		@Override
		public String toString() {
			return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
		}
		
	}
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Main {
		private double temp;
		private double temp_min;
		private double temp_max;
		private double pressure;
		private double humidity;
		public double getTemp() {
			return temp;
		}
		public void setTemp(double temp) {
			this.temp = temp;
		}
		public double getTemp_min() {
			return temp_min;
		}
		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}
		public double getTemp_max() {
			return temp_max;
		}
		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}
		public double getPressure() {
			return pressure;
		}
		public void setPressure(double pressure) {
			this.pressure = pressure;
		}
		public double getHumidity() {
			return humidity;
		}
		public void setHumidity(double humidity) {
			this.humidity = humidity;
		}
		@Override
		public String toString() {
			return "Main [temp=" + temp + ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", pressure=" + pressure
					+ ", humidity=" + humidity + "]";
		}
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Sys{
			private String sunrise;
			private String sunset;

			public String getSunrise() {
				return sunrise;
			}

			public void setSunrise(String sunrise) {
				this.sunrise = sunrise;
			}

			public String getSunset() {
				return sunset;
			}

			public void setSunset(String sunset) {
				this.sunset = sunset;
			}
		}
	}

}
