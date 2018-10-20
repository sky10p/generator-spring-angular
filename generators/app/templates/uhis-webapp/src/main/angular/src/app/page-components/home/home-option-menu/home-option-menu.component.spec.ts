import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeOptionMenuComponent } from './home-option-menu.component';

describe('HomeOptionMenuComponent', () => {
  let component: HomeOptionMenuComponent;
  let fixture: ComponentFixture<HomeOptionMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeOptionMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeOptionMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
