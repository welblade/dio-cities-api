package com.github.welblade.diocitiesapi.cities;

import java.util.Optional;

import com.github.welblade.diocitiesapi.cities.repository.CityRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("cities")
public class CityResource {
    public CityResource(CityRepository repository) {
        this.repository = repository;
    }

    private CityRepository repository;

    @GetMapping
    public ResponseEntity<Page<City>> cities(Pageable page) {
        Page<City> citiesPage = repository.findAll(page);
        Page<City> linkedCitiesPage;
        if(citiesPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            linkedCitiesPage = citiesPage.map(
                city -> {
                    int id = city.getId();
                    return city.add(linkTo(methodOn(CityResource.class).getOne(id)).withSelfRel());
                });
        }
        return new ResponseEntity<Page<City>>(linkedCitiesPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<City> getOne(@PathVariable Integer id) {
        Optional<City> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new CityNotFoundException(id);
        }else{
            response.get().add(linkTo(methodOn(CityResource.class).cities(Pageable.unpaged())).withSelfRel());
        }
        return new ResponseEntity<City>(response.get(), HttpStatus.OK);
    }
}
