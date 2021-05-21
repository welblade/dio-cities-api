package com.github.welblade.diocitiesapi.countries;

import java.util.Optional;

import com.github.welblade.diocitiesapi.countries.repository.CountryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

    // @Autowired
    private CountryRepository repository;
    
    @GetMapping
    Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    Country country(@PathVariable Long id){
        Optional<Country> response = repository.findById(id);
        if(response.isEmpty()){
            throw new CountryNotFoundException(id);
        }
        return response.get();
    }

}
