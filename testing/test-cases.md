# Manual Test Cases (Assignment-2 Brista)

This document outlines the manual testing scenarios for the Aurora Kiosk.

## 1. Authentication & Basic Navigation
| ID | Title | Priority | Pre-condition | Steps | Expected Result |
|----|-------|----------|---------------|-------|-----------------|
| TC-01 | Dashboard Load | High | None | Navigate to http://localhost:8080 | Page renders with Glassmorphism UI |
| TC-02 | Responsive Layout | Medium | Page loaded | Resize browser window | Layout shifts to single column for mobile |

## 2. Analytics Dashboard
| ID | Title | Priority | Pre-condition | Steps | Expected Result |
|----|-------|----------|---------------|-------|-----------------|
| TC-03 | Revenue Chart | High | Sales seeded | Open Analytics tab | Chart displays revenue trends |
| TC-04 | Efficiency Alerts | High | Kiosks seeded | Check Alerts section | Alerts for 'Airport hub' displayed |
| TC-05 | Top Performers | Medium | Sales seeded | Check Top Kiosks | List displays kiosks ordered by efficiency |

## 3. REST API (Postman)
| ID | Title | Priority | Method/URL | Input | Expected Result |
|----|-------|----------|------------|-------|-----------------|
| TC-06 | Get Revenue | High | GET /api/v1/analytics/revenue | None | JSON with Kiosk names and revenue |
| TC-07 | Get Summary | High | GET /api/v1/sales/summary | None | JSON with item types and amounts |
| TC-08 | Get Alerts | High | GET /api/v1/analytics/alerts | None | JSON list of alert strings |
