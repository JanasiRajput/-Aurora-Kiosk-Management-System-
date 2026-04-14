package ca.sheridancollege.rajputja.web.rest;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import ca.sheridancollege.rajputja.domain.Kiosk;
import ca.sheridancollege.rajputja.services.InsightService;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin(origins = "*") // Allow Angular/React frontend access
public class AnalyticsController {

    private final InsightService insightService;

    @GetMapping("/sales/summary")
    public Map<String, Double> getSalesSummary() {
        return insightService.getSalesSummary();
    }

    @GetMapping("/analytics/revenue")
    public Map<String, Double> getRevenueSummary() {
        return insightService.getRevenueByKiosk();
    }

    @GetMapping("/analytics/insights")
    public List<Kiosk> getTopKiosks() {
        return insightService.getTopPerformingKiosks();
    }

    @GetMapping("/analytics/alerts")
    public List<String> getAlerts() {
        return insightService.getEfficiencyAlerts();
    }

    @GetMapping("/analytics/peak-times")
    public Map<Integer, Long> getPeakTimes() {
        return insightService.getPeakTimeAnalysis();
    }

    @GetMapping("/analytics/revenue/trend")
    public List<Map<String, Object>> getRevenueTrend() {
        return insightService.getRevenueTrend();
    }
}
