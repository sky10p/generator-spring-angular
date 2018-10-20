import { AuthService } from './../../services/auth/auth.service';
import { LoginInterceptor } from './login.interceptor';
import { TestBed, inject } from '@angular/core/testing';



describe('LoginInterceptor', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginInterceptor, AuthService]
    });
  });

  it('should be created', inject([LoginInterceptor], (service: LoginInterceptor) => {
    expect(service).toBeTruthy();
  }));
});
