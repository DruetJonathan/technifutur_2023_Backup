import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBurgerAPIComponent } from './add-burger-api.component';

describe('AddBurgerAPIComponent', () => {
  let component: AddBurgerAPIComponent;
  let fixture: ComponentFixture<AddBurgerAPIComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddBurgerAPIComponent]
    });
    fixture = TestBed.createComponent(AddBurgerAPIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
