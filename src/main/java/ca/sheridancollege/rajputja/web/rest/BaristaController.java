package ca.sheridancollege.rajputja.web.rest;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import ca.sheridancollege.rajputja.domain.Barista;
import ca.sheridancollege.rajputja.services.BaristaService;

@RestController
@RequestMapping("/api/v1/baristas")
@AllArgsConstructor
public class BaristaController {

    private final BaristaService service;

    @GetMapping
    public List<Barista> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Barista getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Barista save(@RequestBody Barista b) {
        return service.save(b);
    }
}