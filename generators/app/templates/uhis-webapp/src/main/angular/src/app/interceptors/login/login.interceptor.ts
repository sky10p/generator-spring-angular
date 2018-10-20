import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { HttpRequest, HttpHandler, HttpInterceptor} from '@angular/common/http';



@Injectable()
export class LoginInterceptor implements HttpInterceptor {


  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {
    if (this.authService.isLoggedIn()) {
      const token = this.authService.token;
      const authReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${token}`)
      });

      return next.handle(authReq);
    }

    return next.handle(req);
  }

}
