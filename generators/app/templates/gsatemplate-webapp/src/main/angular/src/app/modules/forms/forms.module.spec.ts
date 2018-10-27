import { <%= appName_CamelCase %>FormsModule } from './forms.module';

describe('<%= appName_CamelCase %>FormsModule', () => {
  let formsModule: <%= appName_CamelCase %>FormsModule;

  beforeEach(() => {
    formsModule = new <%= appName_CamelCase %>FormsModule();
  });

  it('should create an instance', () => {
    expect(formsModule).toBeTruthy();
  });
});
