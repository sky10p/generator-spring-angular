import { TestBed, async, inject } from '@angular/core/testing';

import { CanActivateIfAuthenticatedGuard } from './can-activate-if-authenticated.guard';

describe('CanActivateIfAuthenticatedGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CanActivateIfAuthenticatedGuard]
    });
  });

  it('should ...', inject([CanActivateIfAuthenticatedGuard], (guard: CanActivateIfAuthenticatedGuard) => {
    expect(guard).toBeTruthy();
  }));
});
