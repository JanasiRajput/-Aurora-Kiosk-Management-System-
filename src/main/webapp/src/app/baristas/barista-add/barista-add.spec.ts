import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BaristaAdd } from './barista-add';

describe('BaristaAdd', () => {
  let component: BaristaAdd;
  let fixture: ComponentFixture<BaristaAdd>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BaristaAdd],
    }).compileComponents();

    fixture = TestBed.createComponent(BaristaAdd);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
