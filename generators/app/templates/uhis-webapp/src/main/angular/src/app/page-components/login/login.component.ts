import { LoginService } from '../../services/auth/login.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { NgProgress, NgProgressRef } from '@ngx-progressbar/core';

@Component({
  selector: '<%= prefix_angular %>-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  constructor(private loginService: LoginService, private authService: AuthService, private route:ActivatedRoute,
     private router: Router, private ngProgress: NgProgress) { }

  username: string;
  password: string;
  tokenJwt: string;
  return: string;

  mode: string;
  progressRef: NgProgressRef;

  ngOnInit() {
    this.route.queryParams.subscribe(params => this.prv_getPageReturn(params));

    this.progressRef = this.ngProgress.ref();
    this.progressRef.started.subscribe(() => this.mode = 'indeterminate');
    this.progressRef.completed.subscribe(() => this.mode = '');
  }

  login(username: string, password: string) {
    this.loginService.login(username, password).subscribe(result => {
      this.tokenJwt = this.authService.token;
      this.prv_authenticate();
    });
  }

  ngOnDestroy() {
    this.ngProgress.destroyAll();
  }

  private prv_getPageReturn(params: Params): void {
    this.return = params['return'] || '/';
  }



  private prv_authenticate(): void {
    this.router.navigateByUrl(this.return);
  }



}
