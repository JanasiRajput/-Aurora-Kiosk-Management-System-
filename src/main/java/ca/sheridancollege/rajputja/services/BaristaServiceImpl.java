package ca.sheridancollege.rajputja.services;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ca.sheridancollege.rajputja.domain.Barista;
import ca.sheridancollege.rajputja.repository.BaristaRepository;

@Service
@AllArgsConstructor
public class BaristaServiceImpl implements BaristaService {

    private BaristaRepository repo;

    public List<Barista> findAll() {
        return repo.findAll();
    }

    public Barista findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Barista save(Barista b) {
        return repo.save(b);
    }
}