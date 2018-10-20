import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth/auth.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Route } from '@angular/compiler/src/core';
import { NgProgress, NgProgressRef } from '@ngx-progressbar/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {

  constructor(private authService: AuthService, private router: Router, private ngProgress: NgProgress) { }

  username: string;
  firstLetter: string;

  mode: string;
  progressRef: NgProgressRef;

  ngOnInit() {

    this.username = this.authService.user;
    this.firstLetter = this.prv_firstLetter(this.username);

    this.progressRef = this.ngProgress.ref();
    this.progressRef.started.subscribe(() => this.mode = 'indeterminate');
    this.progressRef.completed.subscribe(() => this.mode = '');
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login'], {queryParams: {return: this.router.url}});
  }

  ngOnDestroy(): void {
    this.ngProgress.destroyAll();
  }

  private prv_firstLetter(text: string): string {
    return text.charAt(0).toUpperCase();
  }

}
