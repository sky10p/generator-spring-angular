import { UhisFormsModule } from './forms.module';

describe('UhisFormsModule', () => {
  let formsModule: UhisFormsModule;

  beforeEach(() => {
    formsModule = new UhisFormsModule();
  });

  it('should create an instance', () => {
    expect(formsModule).toBeTruthy();
  });
});
