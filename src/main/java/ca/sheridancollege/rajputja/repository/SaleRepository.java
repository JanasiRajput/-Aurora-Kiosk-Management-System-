package ca.sheridancollege.rajputja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ca.sheridancollege.rajputja.domain.Sale;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByKioskId(Long kioskId);
}
