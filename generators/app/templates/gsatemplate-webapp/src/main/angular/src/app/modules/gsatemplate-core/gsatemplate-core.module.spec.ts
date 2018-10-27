import { <%= appName_CamelCase %>CoreModule } from './<%= appName %>-core.module';

describe('<%= appName_CamelCase %>CoreModule', () => {
  let <%= appName %>CoreModule: <%= appName_CamelCase %>CoreModule;

  beforeEach(() => {
    <%= appName %>CoreModule = new <%= appName_CamelCase %>CoreModule();
  });

  it('should create an instance', () => {
    expect(<%= appName %>CoreModule).toBeTruthy();
  });
});
