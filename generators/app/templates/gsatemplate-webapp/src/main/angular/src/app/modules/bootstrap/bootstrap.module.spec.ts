import { BootstrapModule } from './bootstrap.module';

describe('BootstrapModuleModule', () => {
  let bootstrapModuleModule: BootstrapModule;

  beforeEach(() => {
    bootstrapModuleModule = new BootstrapModule();
  });

  it('should create an instance', () => {
    expect(bootstrapModuleModule).toBeTruthy();
  });
});
