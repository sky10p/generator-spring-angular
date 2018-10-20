import { UhisCoreModule } from './uhis-core.module';

describe('UhisCoreModule', () => {
  let uhisCoreModule: UhisCoreModule;

  beforeEach(() => {
    uhisCoreModule = new UhisCoreModule();
  });

  it('should create an instance', () => {
    expect(uhisCoreModule).toBeTruthy();
  });
});
