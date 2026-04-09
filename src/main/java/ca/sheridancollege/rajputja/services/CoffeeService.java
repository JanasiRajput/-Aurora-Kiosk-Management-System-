package ca.sheridancollege.rajputja.services;

import java.util.List;
import ca.sheridancollege.rajputja.domain.Coffee;

public interface CoffeeService {
    List<Coffee> findAll();
    Coffee findById(Long id);
    Coffee save(Coffee c);
    boolean deleteById(Long id);
}