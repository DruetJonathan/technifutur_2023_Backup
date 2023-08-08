import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BasesComponent } from './bases/bases.component';
import { ServicesComponent } from './services/services.component';
import { ObservablesComponent } from './observables/observables.component';
import { AddBurgerComponent } from './services/add-burger/add-burger.component';
import { DetailBurgerComponent } from './services/detail-burger/detail-burger.component';
import { EditBurgerComponent } from './services/edit-burger/edit-burger.component';
import {AddBurgerApiComponent} from "./observables/components/add-burger/add-burger.component";
import {ThermometreComponent} from "./observables/components/thermometre/thermometre.component";
import {PanierComponent} from "./components/panier/panier.component";

const routes: Routes = [
  { path : 'bases', component : BasesComponent },
  { path : 'services', component : ServicesComponent },
  { path : 'observables', component : ObservablesComponent },
  { path : 'obs/burger/add', component : AddBurgerApiComponent },
  { path : 'obs/thermometre', component : ThermometreComponent },
  { path : 'burgers/add', component : AddBurgerComponent },
  { path : 'burgers/:id', component : DetailBurgerComponent },
  { path : 'burgers/edit/:id', component : EditBurgerComponent },
  { path : 'panier', component : PanierComponent },

  // { path : 'not-found', compondent : NotFoundComponent },
  // { path : '**', redirectTo : 'not-found' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
