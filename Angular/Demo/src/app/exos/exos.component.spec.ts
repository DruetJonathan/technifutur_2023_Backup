import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExosComponent } from './exos.component';

describe('ExosComponent', () => {
  let component: ExosComponent;
  let fixture: ComponentFixture<ExosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExosComponent]
    });
    fixture = TestBed.createComponent(ExosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
