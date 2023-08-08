import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Exo1Component } from './exo1/exo1.component';
import { Exo2Component } from './exo2/exo2.component';
import { Exo3Component } from './exo3/exo3.component';
import {Exo4Component} from "./exo4/exo4.component";
import {Exo5Component} from "./exo5/exo5.component";
import {SeeDetailsComponent} from "./exo5/see-details/see-details.component";
import {CreateFanSerieComponent} from "./exo5/create-fan-serie/create-fan-serie.component";
import {SharedModule} from "../shared/shared.module";
import {UpdateFanSerieComponent} from "./exo5/update-fan-serie/update-fan-serie.component";
import {Exo6Component} from "./exo6/exo6.component";

const routes: Routes = [
  {
    path: "exo1", component: Exo1Component
  },
  {
    path: "exo2", component: Exo2Component
  },
  {
    path: "exo3", component: Exo3Component
  },
  {
    path: "exo4", component: Exo4Component
  },
  {
    path: "exo5", component: Exo5Component
  },
  {
    path: "exo5/seeDetails/:id", component: SeeDetailsComponent
  },
  {
    path: "exo5/create-fan-serie", component: CreateFanSerieComponent
  },
  {
    path: "exo5/update-fan-serie/:id", component: UpdateFanSerieComponent
  },
  {
    path: "exo6", component: Exo6Component
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes),SharedModule],
  exports: [RouterModule]
})
export class ExosRoutingModule { }
