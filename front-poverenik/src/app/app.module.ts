import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { CreateResenjeComponent } from './resenje/create-resenje/create-resenje.component';
import { DashboardComponent } from './core/dashboard/dashboard.component';
import { HeaderComponent } from './core/header/header.component';
import { LoginComponent } from './core/login/login.component';
import { RegisterComponent } from './core/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateResenjeComponent,
    DashboardComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [FormsModule, ReactiveFormsModule],
})
export class AppModule {}
