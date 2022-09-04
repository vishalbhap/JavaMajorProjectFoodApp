import { TestBed } from '@angular/core/testing';

import { ExportdetailsService } from './exportdetails.service';

describe('ExportdetailsService', () => {
  let service: ExportdetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExportdetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
