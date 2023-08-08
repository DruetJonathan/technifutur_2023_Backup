import { NgModule, LOCALE_ID } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import localeFrBe from '@angular/common/locales/fr-BE';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { RappelsComponent } from './components/rappels/rappels.component';
import { ToFarenheitPipe } from './shared/pipes/to-farenheit.pipe';
import { TrainerCardComponent } from './components/trainer-card/trainer-card.component';
import { NotfoundComponent } from './components/notfound/notfound.component';

registerLocaleData(localeFrBe);

@NgModule({
  declarations: [
    // Toutes les déclarations de composants, de pipes, etc (ils ne peuvent être déclarés que dans un seul module)
    AppComponent,
    NavbarComponent,
    HomeComponent,
    RappelsComponent,
    NotfoundComponent,
  ],
  imports: [
    // Import des modules dont on va avoir besoin
    BrowserModule,
    AppRoutingModule
  ],
  exports : [
    // Modules, Components, Pipes etc qu'on veut rendre exportables dans l'app
    // Pas mis de base, on s'en sert pas tant que ça ici, plutôt dans un module partagé
  ],
  providers: [
    // Informations sur l'injection de dépendances des services, interceptor etc
    { provide : LOCALE_ID, useValue : "fr-BE"}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
