import { UhisFormsModule } from './../forms/forms.module';
import { BootstrapModule } from './../bootstrap/bootstrap.module';
import { MaterialModule } from './../material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JwtModule } from '@auth0/angular-jwt';
import { NgProgressModule } from '@ngx-progressbar/core';
import { NgProgressHttpModule } from '@ngx-progressbar/http';

export function tokenGetter() {
  return localStorage.getItem('access_token');
}

@NgModule({
  imports: [
    CommonModule,
    UhisFormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter
      }
    }),
    NgProgressModule.forRoot(),
    NgProgressHttpModule.forRoot()
  ],
  exports: [
    UhisFormsModule,
    JwtModule,
    NgProgressModule,
    NgProgressHttpModule
  ],
  declarations: []
})
export class UhisCoreModule { }
