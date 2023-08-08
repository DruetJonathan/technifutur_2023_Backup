import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFanSerieComponent } from './update-fan-serie.component';

describe('UpdateFanSerieComponent', () => {
  let component: UpdateFanSerieComponent;
  let fixture: ComponentFixture<UpdateFanSerieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateFanSerieComponent]
    });
    fixture = TestBed.createComponent(UpdateFanSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
