package ca.sheridancollege.rajputja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.rajputja.domain.Coffee;

public interface CoffeeRepository extends JpaRepository <Coffee, Long> {}