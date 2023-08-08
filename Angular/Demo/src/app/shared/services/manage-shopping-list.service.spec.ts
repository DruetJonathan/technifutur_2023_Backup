import { TestBed } from '@angular/core/testing';

import { ManageShoppingListService } from './manage-shopping-list.service';

describe('ManageShoppingListService', () => {
  let service: ManageShoppingListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManageShoppingListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
