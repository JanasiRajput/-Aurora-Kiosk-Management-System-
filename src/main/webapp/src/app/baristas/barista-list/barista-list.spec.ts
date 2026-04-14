import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BaristaList } from './barista-list';

describe('BaristaList', () => {
  let component: BaristaList;
  let fixture: ComponentFixture<BaristaList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BaristaList],
    }).compileComponents();

    fixture = TestBed.createComponent(BaristaList);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
