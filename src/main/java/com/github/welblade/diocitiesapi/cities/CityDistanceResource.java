package com.github.welblade.diocitiesapi.cities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
public class CityDistanceResource {
    private final CityDistanceService service;
    Logger log = LoggerFactory.getLogger(CityDistanceResource.class);
  
    public CityDistanceResource(CityDistanceService service) {
      this.service = service;
    }

    @GetMapping
    public ResponseEntity<Double> byCube(@RequestParam(name = "from") final Integer city1,
                         @RequestParam(name = "to") final Integer city2) {
      log.info("byCube");
      return ResponseEntity.ok().body(service.distance(city1, city2));
    }
}
