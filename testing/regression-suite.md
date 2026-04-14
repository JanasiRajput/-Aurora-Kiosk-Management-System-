# Regression Test Suite (Assignment-2 Brista)

This regression suite ensures core features (Coffee/Barista management) remain stable after the analytics upgrade.

## Core Feature 1: Inventory Management
| ID | Feature | Steps | Expected Result | Result |
|----|---------|-------|-----------------|--------|
| REG-01 | List Coffee | Check /api/v1/coffees | Return list of 10 coffee types | [ ] |
| REG-02 | Create Coffee | POST /api/v1/coffees | New coffee saved successfully | [ ] |

## Core Feature 2: Personnel
| ID | Feature | Steps | Expected Result | Result |
|----|---------|-------|-----------------|--------|
| REG-03 | List Baristas | Check Barista Page | 3 Baristas (John, Emma, Liam) displayed | [ ] |

## Core Feature 3: Data Integrity
| ID | Feature | Steps | Expected Result | Result |
|----|---------|-------|-----------------|--------|
| REG-04 | Startup Seed | Start App | Total coffee count = 10, total sales > 400 | [ ] |
| REG-05 | Persistence | Restart App | All sales and kiosks remain in database | [ ] |
