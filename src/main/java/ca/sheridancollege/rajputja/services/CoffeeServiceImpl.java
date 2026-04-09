package ca.sheridancollege.rajputja.services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ca.sheridancollege.rajputja.domain.Coffee;
import ca.sheridancollege.rajputja.repository.CoffeeRepository;

@Service
@AllArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private CoffeeRepository repo;

    public List<Coffee> findAll() {
        return repo.findAll();
    }

    public Coffee findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Coffee save(Coffee c) {
        return repo.save(c);
    }

    public boolean deleteById(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}