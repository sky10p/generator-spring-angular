import { Routes } from '@angular/router';
import { LoginComponent } from 'src/app/page-components/login/login.component';
import { HomeComponent } from 'src/app/page-components/home/home.component';
import { CanActivateIfAuthenticatedGuard } from 'src/app/guards/can-activate-if-authenticated.guard';
import { CanActivateLoginGuard } from 'src/app/guards/can-activate-login.guard';
import { MainComponent } from 'src/app/core-components/main/main.component';

export const routes: Routes = [
  {path: '', component: MainComponent, canActivate: [CanActivateIfAuthenticatedGuard]},
  {path: 'login', component: LoginComponent, canActivate: [CanActivateLoginGuard]}
];
