package com.github.welblade.diocitiesapi.cities;

import java.util.List;

import com.github.welblade.diocitiesapi.cities.repository.CityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class CityDistanceService {
    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(CityDistanceService.class);
  
    public CityDistanceService(final CityRepository cityRepository) {
      this.cityRepository = cityRepository;
    }
 /**
   * distance
   *
   * @param Integer city1
   * @param Integer city2
   * @return Double
   */
  public Double distance(Integer city1, Integer city2) {
    log.info("distanceByCubeInMeters({}, {})", city1, city2);
    final List<City> cities = cityRepository.findAllById((List.of(city1, city2)));

    Point p1 = new Point(cities.get(0).getLatitude(), cities.get(0).getLongitude());
    Point p2 = new Point(cities.get(1).getLatitude(), cities.get(1).getLongitude());

    return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
  }
}
