# Bug Reports & Fixes (Assignment-2 Brista)

This document tracks issues identified during the development of 'Smart Operations'.

## Open Issues
*None currently identified.*

## Resolved Issues

### BUG-001: Ambiguous Analytics Mapping
- **Description**: Initial AnalyticsController route overlapped with static resource path.
- **Fix**: Standardized @RequestMapping to `/api/v1`.
- **Status**: Fixed

### BUG-002: Sale Timestamp Variance
- **Description**: All sales seeded with identical timestamps in first iteration.
- **Fix**: Random distribution over 30 days added to BootstrapData.
- **Status**: Fixed

### BUG-003: CORS Policy Block
- **Description**: Blocked requests to backend from local frontend.
- **Fix**: Added `@CrossOrigin(origins = "*")` to AnalyticsController.
- **Status**: Fixed
