import { BootstrapModule } from './../bootstrap/bootstrap.module';
import { MaterialModule } from './../material/material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    BootstrapModule,
    HttpClientModule
  ],
  exports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    BootstrapModule,
    HttpClientModule
  ],
  declarations: []
})
export class CoreModule { }
