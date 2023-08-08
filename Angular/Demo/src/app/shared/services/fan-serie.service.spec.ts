import { TestBed } from '@angular/core/testing';

import { FanSerieService } from './fan-serie.service';

describe('FanSerieService', () => {
  let service: FanSerieService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FanSerieService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
