import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Token } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  static readonly LOCALSTORAGE_TOKEN_KEY = 'token';

  constructor(private jwtHelper: JwtHelperService) { }

  tokenChange = new Subject();

  set token(token: string) {
    if (token == null) {
      localStorage.removeItem(AuthService.LOCALSTORAGE_TOKEN_KEY);
    } else {
      localStorage.setItem(AuthService.LOCALSTORAGE_TOKEN_KEY, token);
    }

    this.tokenChange.next(token);
  }

  get token() {
    return localStorage.getItem(AuthService.LOCALSTORAGE_TOKEN_KEY);
  }

  get user() {
    if (this.token === null) {
      return null;
    }

    const jwtDecoded = this.jwtHelper.decodeToken(this.token);
    return jwtDecoded.sub;
  }

  public hasRole(role: string) {
    const token = this.jwtHelper.decodeToken(this.token);
    const roles = token.authorities.split(',');

    return roles.includes(role);
  }

  public isLoggedIn(): boolean {
    return this.token !== null;
  }

  public logout(): void {
    this.token = null;
  }

  isAdmin(): boolean {
    return this.hasRole('ADMIN');
  }
}
