import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeAdd } from './coffee-add';

describe('CoffeeAdd', () => {
  let component: CoffeeAdd;
  let fixture: ComponentFixture<CoffeeAdd>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeAdd],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeAdd);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
