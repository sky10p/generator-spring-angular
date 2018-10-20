import { Component } from '@angular/core';
import { MatIconRegistry } from '@angular/material/icon';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private matIconRegistry: MatIconRegistry, private sanitizer: DomSanitizer) {
    this.prv_addIcon('settings');
    this.prv_addIcon('notification');
    this.prv_addIcon('logout');
  }

  title = 'uhis';

  private prv_addIcon(iconName: string) {
    const url = `assets/images/icons/${iconName}.svg`;
    this.matIconRegistry.addSvgIcon(iconName, this.sanitizer.bypassSecurityTrustResourceUrl(url));
  }
}
