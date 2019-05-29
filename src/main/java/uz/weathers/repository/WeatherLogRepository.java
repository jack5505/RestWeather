package uz.weathers.repository;

import org.springframework.data.repository.CrudRepository;

import uz.weathers.model.WeatherEntity;

public interface WeatherLogRepository extends CrudRepository<WeatherEntity, Integer> {

}
