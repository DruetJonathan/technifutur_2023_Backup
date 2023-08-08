import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExoRoutingModule } from './exo-routing.module';
import { ExoComponent } from './exo.component';
import { Exo1Component } from './exo1/exo1.component';
import { SharedModule } from '../shared/shared.module';
import { Exo2Component } from './exo2/exo2.component';
import { Exo2enfantComponent } from './exo2/exo2enfant/exo2enfant.component';
import { Exo3Component } from './exo3/exo3.component';
import { Exo3enfantComponent } from './exo3/exo3enfant/exo3enfant.component';
import { Exo4Component } from './exo4/exo4.component';


@NgModule({
  declarations: [
    ExoComponent,
    Exo1Component,
    Exo2Component,
    Exo2enfantComponent,
    Exo3Component,
    Exo3enfantComponent,
    Exo4Component
  ],
  imports: [
    CommonModule,
    ExoRoutingModule,
    SharedModule
  ]
})
export class ExoModule { }
