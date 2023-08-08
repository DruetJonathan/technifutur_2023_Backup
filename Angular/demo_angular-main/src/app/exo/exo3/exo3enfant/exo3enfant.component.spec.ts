import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exo3enfantComponent } from './exo3enfant.component';

describe('Exo3enfantComponent', () => {
  let component: Exo3enfantComponent;
  let fixture: ComponentFixture<Exo3enfantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Exo3enfantComponent]
    });
    fixture = TestBed.createComponent(Exo3enfantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
