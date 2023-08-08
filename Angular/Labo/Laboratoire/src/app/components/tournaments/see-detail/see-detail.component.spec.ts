import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeDetailComponent } from './see-detail.component';

describe('SeeDetailComponent', () => {
  let component: SeeDetailComponent;
  let fixture: ComponentFixture<SeeDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SeeDetailComponent]
    });
    fixture = TestBed.createComponent(SeeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
