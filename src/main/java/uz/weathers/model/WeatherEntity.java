package uz.weathers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="weathers")
public class WeatherEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private int id;

	@Column
	private String location;

	@Column(name="actualweather")
	private String actualWeather;

	@Column
	private String temperature;
	
	@Column(name="dtimeinserted")
	@JsonIgnore
	private Date dtimeInserted;

	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getActualWeather() {
		return actualWeather;
	}
	public void setActualWeather(String actualWeather) {
		this.actualWeather = actualWeather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDtimeInserted() {
		return dtimeInserted;
	}
	public void setDtimeInserted(Date dtimeInserted) {
		this.dtimeInserted = dtimeInserted;
	}

	@Override
	public String toString() {
		return "WeatherEntity{" +
				"id=" + id +
				", location='" + location + '\'' +
				", actualWeather='" + actualWeather + '\'' +
				", temperature='" + temperature + '\'' +
				", dtimeInserted=" + dtimeInserted +
				'}';
	}
}
