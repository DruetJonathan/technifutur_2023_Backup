import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DemoRoutingModule } from './demo-routing.module';
import { DemoComponent } from './demo.component';
import { Demo1Component } from './demo1/demo1.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Demo2Component } from './demo2/demo2.component';
import { SharedModule } from '../shared/shared.module';
import { Demo3Component } from './demo3/demo3.component';
import { Demo4Component } from './demo4/demo4.component';
import { Demo4EnfantComponent } from './demo4/demo4-enfant/demo4-enfant.component';
import { Demo5Component } from './demo5/demo5.component';
import { Demo6Component } from './demo6/demo6.component';
import { Demo7Component } from './demo7/demo7.component';
import { CreateTrackComponent } from './demo7/create-track/create-track.component';
import { UpdateTrackComponent } from './demo7/update-track/update-track.component';
import { Demo8Component } from './demo8/demo8.component';


@NgModule({
  declarations: [
    DemoComponent,
    Demo1Component,
    Demo2Component,
    Demo3Component,
    Demo4Component,
    Demo4EnfantComponent,
    Demo5Component,
    Demo6Component,
    Demo7Component,
    CreateTrackComponent,
    UpdateTrackComponent,
    Demo8Component
  ],
  imports: [
    CommonModule,
    DemoRoutingModule,
    FormsModule,
    SharedModule
  ],
  bootstrap: [DemoComponent]
})
export class DemoModule { }
