import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExosRoutingModule } from './exos-routing.module';
import { ExosComponent } from './exos.component';
import { Exo1Component } from './exo1/exo1.component';
import { Exo2Component } from './exo2/exo2.component';
import { SharedModule } from '../shared/shared.module';
import { Exo2EnfantComponent } from './exo2/exo2-enfant/exo2-enfant.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { Exo3Component } from './exo3/exo3.component';
import { Exo3EnfantComponent } from './exo3/exo3-enfant/exo3-enfant.component';
import { Exo4Component } from './exo4/exo4.component';
import { Exo5Component } from './exo5/exo5.component';
import { SeeDetailsComponent } from './exo5/see-details/see-details.component';
import { CreateFanSerieComponent } from './exo5/create-fan-serie/create-fan-serie.component';
import { UpdateFanSerieComponent } from './exo5/update-fan-serie/update-fan-serie.component';
import { Exo6Component } from './exo6/exo6.component';


@NgModule({
  declarations: [
    ExosComponent,
    Exo1Component,
    Exo2Component,
    Exo2EnfantComponent,
    Exo3Component,
    Exo3EnfantComponent,
    Exo4Component,
    Exo5Component,
    SeeDetailsComponent,
    CreateFanSerieComponent,
    UpdateFanSerieComponent,
    Exo6Component
  ],
  imports: [
    CommonModule,
    ExosRoutingModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule
  ],
  bootstrap: [ExosComponent]

})
export class ExosModule { }
