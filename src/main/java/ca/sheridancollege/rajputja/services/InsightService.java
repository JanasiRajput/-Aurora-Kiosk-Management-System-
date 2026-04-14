package ca.sheridancollege.rajputja.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import ca.sheridancollege.rajputja.domain.Kiosk;
import ca.sheridancollege.rajputja.domain.Sale;
import ca.sheridancollege.rajputja.repository.KioskRepository;
import ca.sheridancollege.rajputja.repository.SaleRepository;

@Service
@AllArgsConstructor
public class InsightService {

    private final KioskRepository kioskRepository;
    private final SaleRepository saleRepository;

    public List<Kiosk> getTopPerformingKiosks() {
        return kioskRepository.findAll().stream()
            .sorted((k1, k2) -> Double.compare(k2.getEfficiencyScore(), k1.getEfficiencyScore()))
            .limit(3)
            .collect(Collectors.toList());
    }

    public List<String> getEfficiencyAlerts() {
        return kioskRepository.findAll().stream()
            .filter(k -> k.getEfficiencyScore() < 7.0 || k.getStatus().equals("MAINTENANCE"))
            .map(k -> "Alert: Kiosk '" + k.getName() + "' has low efficiency (" + k.getEfficiencyScore() + ") or is under maintenance.")
            .collect(Collectors.toList());
    }

    public Map<String, Double> getSalesSummary() {
        List<Sale> allSales = saleRepository.findAll();
        return allSales.stream()
            .collect(Collectors.groupingBy(Sale::getItemType, Collectors.summingDouble(Sale::getAmount)));
    }

    public Map<String, Double> getRevenueByKiosk() {
        List<Sale> allSales = saleRepository.findAll();
        Map<Long, Double> revenueMap = allSales.stream()
            .collect(Collectors.groupingBy(Sale::getKioskId, Collectors.summingDouble(Sale::getAmount)));
        
        return kioskRepository.findAll().stream()
            .collect(Collectors.toMap(Kiosk::getName, k -> revenueMap.getOrDefault(k.getId(), 0.0)));
    }

    public Map<Integer, Long> getPeakTimeAnalysis() {
        return saleRepository.findAll().stream()
            .collect(Collectors.groupingBy(s -> s.getTimestamp().getHour(), Collectors.counting()));
    }

    public List<Map<String, Object>> getRevenueTrend() {
        return saleRepository.findAll().stream()
            .collect(Collectors.groupingBy(s -> s.getTimestamp().toLocalDate().toString()))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .map(e -> {
                Map<String, Object> map = new java.util.HashMap<>();
                map.put("date", e.getKey());
                map.put("revenue", e.getValue().stream().mapToDouble(Sale::getAmount).sum());
                return map;
            })
            .collect(Collectors.toList());
    }
}
