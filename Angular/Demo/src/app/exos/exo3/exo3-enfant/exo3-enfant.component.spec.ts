import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Exo3EnfantComponent } from './exo3-enfant.component';

describe('Exo3EnfantComponent', () => {
  let component: Exo3EnfantComponent;
  let fixture: ComponentFixture<Exo3EnfantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Exo3EnfantComponent]
    });
    fixture = TestBed.createComponent(Exo3EnfantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
