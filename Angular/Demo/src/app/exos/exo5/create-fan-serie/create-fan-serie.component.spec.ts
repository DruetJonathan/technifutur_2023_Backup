import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateFanSerieComponent } from './create-fan-serie.component';

describe('CreateFanSerieComponent', () => {
  let component: CreateFanSerieComponent;
  let fixture: ComponentFixture<CreateFanSerieComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateFanSerieComponent]
    });
    fixture = TestBed.createComponent(CreateFanSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
