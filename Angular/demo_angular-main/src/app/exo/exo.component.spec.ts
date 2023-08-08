import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExoComponent } from './exo.component';

describe('ExoComponent', () => {
  let component: ExoComponent;
  let fixture: ComponentFixture<ExoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExoComponent]
    });
    fixture = TestBed.createComponent(ExoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
