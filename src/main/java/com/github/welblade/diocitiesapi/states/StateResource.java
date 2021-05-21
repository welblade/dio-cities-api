package com.github.welblade.diocitiesapi.states;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.welblade.diocitiesapi.states.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateResource {

    StateResource(StateRepository repository) {
        this.repository = repository;
    }

    private StateRepository repository;

    @GetMapping
    Page<State> states(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    State state(@PathVariable Integer id) {
        Optional<State> response = repository.findById(id);
        if (response.isEmpty()) {
            throw new StateNotFoundException(id);
        }
        return response.get();
    }
}
