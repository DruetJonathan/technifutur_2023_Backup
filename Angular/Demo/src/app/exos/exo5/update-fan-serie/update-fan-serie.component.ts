import { Component } from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {FanSerieService} from "../../../shared/services/fan-serie.service";
import {fanSerie} from "../../../shared/models/fanSerie";

@Component({
  selector: 'app-update-fan-serie',
  templateUrl: './update-fan-serie.component.html',
  styleUrls: ['./update-fan-serie.component.scss']
})
export class UpdateFanSerieComponent {
  createForm : FormGroup;
  id : number;
  fanSerie! : fanSerie | undefined;
  constructor(private _router : Router,private _activeRoute : ActivatedRoute,private _fb : FormBuilder,private _fanSerieService : FanSerieService) {
    this.id = parseInt(this._activeRoute.snapshot.params["id"]);
    this.fanSerie = _fanSerieService.getById(this.id)!;
    this.createForm = this._fb.group({
      nom:[null,Validators.required],
      ddn:[null, [Validators.required,this.ddnValidator()]],
      series:this._fb.array([])
    });

  }
  ngOnInit(): void {
    this.fanSerie = this._fanSerieService.getById(this.id);
    console.log(this.fanSerie);

    //? Ajouter un input pour chacun des artistes
    this.fanSerie?.series.forEach(s => this.addSerie());

    // ? mettre a jour le formulaire
    this.createForm.patchValue({
      nom: this.fanSerie?.nom,
      ddn: this.formatDate(this.fanSerie?.ddn), //-> 'annee-mois-jour',
      series: this.fanSerie?.series
    })
  }
  private formatDate(date: Date | undefined) {
    if (date) {
      const d = new Date(date);
      let month = '' + (d.getMonth() + 1);
      let day = '' + d.getDate();
      const year = d.getFullYear();
      if (month.length < 2) month = '0' + month;
      if (day.length < 2) day = '0' + day;
      return [year, month, day].join('-');
    }

    return null

  }
  updateFanSerie():void{
    if (this.createForm.valid){
      this._fanSerieService.update(this.id,this.createForm.value);
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
