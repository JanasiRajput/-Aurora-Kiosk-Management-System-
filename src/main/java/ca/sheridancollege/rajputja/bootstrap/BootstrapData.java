package ca.sheridancollege.rajputja.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.rajputja.domain.*;
import ca.sheridancollege.rajputja.services.*;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BaristaService baristaService;
    private final CoffeeService coffeeService;

    public BootstrapData(BaristaService baristaService, CoffeeService coffeeService) {
        this.baristaService = baristaService;
        this.coffeeService = coffeeService;
    }

    @Override
    public void run(String... args) {

        if (baristaService.findAll().size() > 0) return;

        // 3 Baristas
        baristaService.save(Barista.builder().name("John").build());
        baristaService.save(Barista.builder().name("Emma").build());
        baristaService.save(Barista.builder().name("Liam").build());

        // 10 Coffees
        for (int i = 1; i <= 10; i++) {
            coffeeService.save(
                Coffee.builder()
                    .name("Coffee " + i)
                    .price(2.5 + i)
                    .quantity(5 + i)
                    .employeeName("John")
                    .build()
            );
        }
    }
}