import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DemoComponent } from './demo/demo.component';
import { ExoComponent } from './exo/exo.component';
import { RappelsComponent } from './components/rappels/rappels.component';
import { NotfoundComponent } from './components/notfound/notfound.component';

const routes: Routes = [
  { path : '', component : HomeComponent },
  // Lazy-Loading - C'est au moment où on va cliquer sur Demo que les enfants vont être chargés, puisqu'il va charger DemoModule, dans lequel nous avons importé le DemoRoutingModule
  { path : 'rappels', component : RappelsComponent },
  { path : 'demo', component : DemoComponent, loadChildren : () => import("./demo/demo.module").then((m) => m.DemoModule ) },
  { path : 'exo', component : ExoComponent, loadChildren : () => import("./exo/exo.module").then((m) => m.ExoModule ) },
  { path : '404notfound', component : NotfoundComponent },
  // ! A mettre en dernier 
  //Signifie " toutes les autres routes qui ne sont pas celles spécifiées au dessus" (en prenant compte les routes enfants) 
  { path : '**', redirectTo : '404notfound' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
