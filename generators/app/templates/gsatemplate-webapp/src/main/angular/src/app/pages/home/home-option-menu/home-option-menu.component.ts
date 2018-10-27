import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: '<%= prefix_angular %>-home-option-menu',
  templateUrl: './home-option-menu.component.html',
  styleUrls: ['./home-option-menu.component.css']
})
export class HomeOptionMenuComponent implements OnInit {

  @Input()
  title: string;

  @Input()
  subtitle: string;
  _url: string;

  constructor() { }

  ngOnInit() {
  }

  @Input()
  set urlImage(url: string) {
    this._url = `assets/images/icons/home/${url}.png`;
  }

  get urlImage() {
    return this._url;
  }
}
