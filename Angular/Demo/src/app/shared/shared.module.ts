import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToFarenheitPipe } from './pipes/to-farenheit.pipe';
import { ConvertTempPipe } from './pipes/convert-temp.pipe';
import { FormatChronoPipe } from './pipes/format-chrono.pipe';
import { HighlightDirective } from './directives/highlight.directive';
import { TrainerCardComponent } from '../components/trainer-card/trainer-card.component';
import { ManageShoppingListService } from './services/manage-shopping-list.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

// ? Module partagé qui va snous servire à déclarer des fonctionnalités qu'on voudra rendre disponibles pour toute l'app grâce à l'export

@NgModule({
  declarations: [
    ToFarenheitPipe,
    ConvertTempPipe,
    FormatChronoPipe,
    HighlightDirective,
    TrainerCardComponent,

  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  exports: [
    ToFarenheitPipe,
    ConvertTempPipe,
    FormatChronoPipe,
    HighlightDirective,
    TrainerCardComponent,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ]
})
export class SharedModule { }
