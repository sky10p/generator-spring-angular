import { CoreModule } from './modules/core/core.module';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './pages/login/login.component';
import { <%= appName_CamelCase %>CoreModule } from './modules/<%= appName %>-core/<%= appName %>-core.module';
import { RoutingModule } from './modules/routing/routing.module';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './core/header/header.component';
import { MainComponent } from './core/main/main.component';
import { HomeOptionMenuComponent } from './pages/home/home-option-menu/home-option-menu.component';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorHandlerInterceptor } from './interceptors/error-handler/error-handler.interceptor';
import { LoginInterceptor } from './interceptors/login/login.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    MainComponent,
    HomeOptionMenuComponent
  ],
  imports: [
    CoreModule,
    <%= appName_CamelCase %>CoreModule,
    RoutingModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: ErrorHandlerInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: LoginInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
