package ca.sheridancollege.rajputja.web.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import ca.sheridancollege.rajputja.domain.Coffee;
import ca.sheridancollege.rajputja.services.CoffeeService;

@RestController
@RequestMapping("/api/v1/coffees")
@AllArgsConstructor
public class CoffeeController {

    private final CoffeeService service;

    @GetMapping
    public List<Coffee> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Coffee getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Coffee save(@RequestBody Coffee c) {
        return service.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}