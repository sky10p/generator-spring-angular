import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { environment } from 'src/environments/environment.prod';
import { routes } from './routes';



@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes, {enableTracing: true})
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class RoutingModule { }

