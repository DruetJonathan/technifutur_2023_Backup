import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { DemoComponent } from './demo/demo.component';
import { ExosComponent } from './exos/exos.component';
import {NotfoundComponent} from "./components/notfound/notfound.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    //? loadchildren -> lire les enfants then charger le module demo
    path: 'demo', component: DemoComponent, loadChildren: () =>
      import("./demo/demo.module").then((m) => m.DemoModule)
  },
  {
    path: 'exos', component: ExosComponent, loadChildren: () =>
      import("./exos/exos.module").then((m) => m.ExosModule)
  },
  {path :'404notfound',component: NotfoundComponent},
  {path:'**',redirectTo:'404notfound'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
