package ca.sheridancollege.rajputja.services;

import java.util.List;
import ca.sheridancollege.rajputja.domain.Barista;

public interface BaristaService {
    List<Barista> findAll();
    Barista findById(Long id);
    Barista save(Barista b);
}