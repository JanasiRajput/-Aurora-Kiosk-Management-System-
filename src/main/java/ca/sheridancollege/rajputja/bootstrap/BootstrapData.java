package ca.sheridancollege.rajputja.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.rajputja.domain.*;
import ca.sheridancollege.rajputja.services.*;
import ca.sheridancollege.rajputja.repository.*;
import java.util.Random;
import java.time.LocalDateTime;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BaristaService baristaService;
    private final CoffeeService coffeeService;
    private final KioskRepository kioskRepository;
    private final SaleRepository saleRepository;

    public BootstrapData(BaristaService baristaService, CoffeeService coffeeService, 
                        KioskRepository kioskRepository, SaleRepository saleRepository) {
        this.baristaService = baristaService;
        this.coffeeService = coffeeService;
        this.kioskRepository = kioskRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public void run(String... args) {

        // Seed Baristas if empty
        if (baristaService.findAll().isEmpty()) {
            baristaService.save(Barista.builder().name("John").build());
            baristaService.save(Barista.builder().name("Emma").build());
            baristaService.save(Barista.builder().name("Liam").build());
        }

        // Seed Kiosks if empty
        if (kioskRepository.count() == 0) {
            kioskRepository.save(Kiosk.builder().name("Main Lobby").location("Building A").status("ACTIVE").efficiencyScore(8.5).build());
            kioskRepository.save(Kiosk.builder().name("Gym Corner").location("Building B").status("ACTIVE").efficiencyScore(7.2).build());
            kioskRepository.save(Kiosk.builder().name("Airport Hub").location("Terminal 2").status("MAINTENANCE").efficiencyScore(4.5).build());
            kioskRepository.save(Kiosk.builder().name("Student Union").location("Building C").status("ACTIVE").efficiencyScore(9.1).build());
            kioskRepository.save(Kiosk.builder().name("Tech Park").location("Building D").status("ACTIVE").efficiencyScore(6.8).build());
        }

        // Seed Sales if empty
        if (saleRepository.count() == 0) {
            String[] coffeeNames = {"Espresso", "Latte", "Cappuccino", "Americano", "Mocha", "Flat White", "Macchiato", "Iced Coffee", "Cold Brew", "Affogato"};
            java.util.Random rand = new java.util.Random();
            java.time.LocalDateTime now = java.time.LocalDateTime.now();

            for (int day = 0; day < 30; day++) {
                for (int saleCount = 0; saleCount < 15; saleCount++) {
                    int coffeeIdx = rand.nextInt(coffeeNames.length);
                    saleRepository.save(
                        Sale.builder()
                            .amount(3.5 + rand.nextDouble() * 5)
                            .timestamp(now.minusDays(day).minusHours(rand.nextInt(12)).minusMinutes(rand.nextInt(60)))
                            .kioskId((long) (rand.nextInt(5) + 1))
                            .itemType(coffeeNames[coffeeIdx])
                            .build()
                    );
                }
            }
        }

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