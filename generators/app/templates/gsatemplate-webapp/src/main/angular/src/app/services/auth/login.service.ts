import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map  } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  static readonly AUTHORIZATION = 'authorization';
  static readonly LOGIN_URL: string = 'api/v1/login';


  private static prv_addBearerTokenToLocalStorage(bearerTokenResponse: HttpResponse<string>, authService: AuthService): boolean {
    let loginResult;
    if (bearerTokenResponse.headers.has(LoginService.AUTHORIZATION)) {
      const tokenBearer = bearerTokenResponse.headers.get(LoginService.AUTHORIZATION);
      const token = tokenBearer.replace('Bearer ', '');
      authService.token = token;
      loginResult = true;
    } else {
      loginResult = false;
    }

    return loginResult;
  }

  public login(username: string, password: string): Observable<boolean> {
    const user = {username: username, password: password};
    const doLoginHttpPost$ = this.http.post<string>(LoginService.LOGIN_URL, user, {observe: 'response'});
    const fnAddToHeader = bearerTokenResponse => LoginService.prv_addBearerTokenToLocalStorage(bearerTokenResponse, this.authService);
    const loginResponse$ =  doLoginHttpPost$.pipe(map(fnAddToHeader));
    return loginResponse$;
  }



}
