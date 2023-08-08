import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { TournamentsComponent } from './components/tournaments/tournaments.component';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { SeeDetailComponent } from './components/tournaments/see-detail/see-detail.component';
import { AddTournamentComponent } from './components/tournaments/add-tournament/add-tournament.component';
import {JwtInterceptor} from "./interceptors/jwt.interceptor";
import { LoginComponent } from './components/member/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AccesDeniedComponent } from './components/acces-denied/acces-denied.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {NewMemberComponent} from "./components/member/new-member/new-member.component";
import {ProfilComponent} from "./components/member/profil/profil.component";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TournamentsComponent,
    SeeDetailComponent,
    AddTournamentComponent,
    LoginComponent,
    HomeComponent,
    AccesDeniedComponent,
    NotFoundComponent,
    NewMemberComponent,
    ProfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
