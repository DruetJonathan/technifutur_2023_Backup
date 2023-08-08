import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RappelsComponent } from './rappels.component';

describe('RappelsComponent', () => {
  let component: RappelsComponent;
  let fixture: ComponentFixture<RappelsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RappelsComponent]
    });
    fixture = TestBed.createComponent(RappelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
