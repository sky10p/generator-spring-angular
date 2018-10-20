import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorMessage } from 'src/app/models/errors/error-message';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable()
export class ErrorHandlerInterceptor implements HttpInterceptor {



  constructor(private snackBar: MatSnackBar) { }

  private static readonly DEFAULT_ERROR: ErrorMessage = {message: 'Error Http',
   name: 'InvalidHttpException', status: 500};

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<any> {
    return next.handle(req).pipe(catchError(err => this.prv_showError(err)));
  }

  private prv_showError(err: any) {
    let error: ErrorMessage;
    if (err.error.message) {
      error = err.error ;
    } else {
      error = ErrorHandlerInterceptor.DEFAULT_ERROR;
    }

    this.snackBar.open(`${error.name}: ${error.message} (code=${error.status})`, '', {duration: 5000});
    return throwError(err);
  }
}
