import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentFilterComponent } from './rent-filter.component';

describe('RentFilterComponent', () => {
  let component: RentFilterComponent;
  let fixture: ComponentFixture<RentFilterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentFilterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
