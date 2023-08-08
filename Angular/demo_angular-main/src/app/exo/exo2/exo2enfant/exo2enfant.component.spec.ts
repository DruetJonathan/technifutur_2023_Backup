import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exo2enfantComponent } from './exo2enfant.component';

describe('Exo2enfantComponent', () => {
  let component: Exo2enfantComponent;
  let fixture: ComponentFixture<Exo2enfantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Exo2enfantComponent]
    });
    fixture = TestBed.createComponent(Exo2enfantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
