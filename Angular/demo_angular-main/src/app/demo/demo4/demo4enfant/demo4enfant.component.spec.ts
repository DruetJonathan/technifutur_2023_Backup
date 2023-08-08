import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Demo4enfantComponent } from './demo4enfant.component';

describe('Demo4enfantComponent', () => {
  let component: Demo4enfantComponent;
  let fixture: ComponentFixture<Demo4enfantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Demo4enfantComponent]
    });
    fixture = TestBed.createComponent(Demo4enfantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
