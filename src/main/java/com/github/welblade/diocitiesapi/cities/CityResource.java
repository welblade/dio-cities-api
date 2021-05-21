package com.github.welblade.diocitiesapi.cities;

import java.util.Optional;

import com.github.welblade.diocitiesapi.cities.repository.CityRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
public class CityResource {
    public CityResource(CityRepository repository) {
        this.repository = repository;
    }

    private CityRepository repository;

    @GetMapping
    public Page<City> cities(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    City country(@PathVariable Integer id) {
        Optional<City> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new CityNotFoundException(id);
        }
        return response.get();
    }
}
