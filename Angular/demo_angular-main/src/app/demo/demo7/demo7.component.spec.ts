import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Demo7Component } from './demo7.component';

describe('Demo7Component', () => {
  let component: Demo7Component;
  let fixture: ComponentFixture<Demo7Component>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Demo7Component]
    });
    fixture = TestBed.createComponent(Demo7Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
