import { Component } from '@angular/core';
import {AbstractControl, Form, FormArray, FormBuilder, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {FanSerieService} from "../../../shared/services/fan-serie.service";

@Component({
  selector: 'app-create-fan-serie',
  templateUrl: './create-fan-serie.component.html',
  styleUrls: ['./create-fan-serie.component.scss']
})
export class CreateFanSerieComponent {
  createForm : FormGroup;
  constructor(private _fb: FormBuilder, private _router : Router,private _fanSerieService : FanSerieService) {
    this.createForm = this._fb.group({
      nom:[null,Validators.required],
      ddn:[null, [Validators.required,this.ddnValidator()]],
      series:this._fb.array([])
    });
  }
  addFanSerie():void{
    if (this.createForm.valid){
      this._fanSerieService.add(this.createForm.value);
      this._router.navigateByUrl('exos/exo5')
    }
    else{
      this.createForm.markAllAsTouched();
    }
  }
  get series(): FormArray{
    return this.createForm.get('series') as FormArray;
  }
  addSerie():void{
    this.series.push(this._fb.control(null))
  }
  removeSerie(i:number):void{
    this.series.removeAt(i);
  }
  ddnValidator():ValidatorFn | null{
    return (control : AbstractControl) => {
      console.log(new Date().getFullYear() - control.value >= 13)
      if (control.value && (new Date().getFullYear() - new Date(control.value).getFullYear() < 13)){
        return {invalidDDN : true};
      }
      return null;
    };
  }
}
