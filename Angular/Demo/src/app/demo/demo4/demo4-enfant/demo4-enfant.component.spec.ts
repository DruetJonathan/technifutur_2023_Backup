import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Demo4EnfantComponent } from './demo4-enfant.component';

describe('Demo4EnfantComponent', () => {
  let component: Demo4EnfantComponent;
  let fixture: ComponentFixture<Demo4EnfantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Demo4EnfantComponent]
    });
    fixture = TestBed.createComponent(Demo4EnfantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
