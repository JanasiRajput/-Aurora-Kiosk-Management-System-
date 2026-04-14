# Test Strategy (Assignment-2 Brista)

This strategy document outlines the approach, tools, and methodology for testing the Aurora Kiosk.

## 1. Testing Objective
To ensure that the "Smart Operations & Analytics Dashboard" functions correctly and provides accurate insights while maintaining the integrity of original features.

## 2. Testing Levels
- **Unit Testing**: Logic for revenue calculation and kiosk scoring.
- **Integration Testing**: Communication between Spring Boot REST API and Angular frontend.
- **System Testing**: End-to-end verification of the dashboard.

## 3. Methodology
- **Ad-hoc Testing**: Visual UI bugs.
- **Regression Testing**: Re-running all core feature tests.
- **Performance Testing**: Sales data generation speed.

## 4. Tools
- **Browser**: Chrome/Edge.
- **API Client**: Postman (Shared collection).
- **IDE**: Eclipse and VS Code.

## 5. Pass/Fail Criteria
- **Pass**: All REST endpoints return 200 OK, charts display accurate trends.
- **Fail**: Incorrect revenue figures, chart rendering failures.
