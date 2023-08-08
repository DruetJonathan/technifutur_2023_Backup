import { Component } from '@angular/core';
import {Form, FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-exo4',
  templateUrl: './exo4.component.html',
  styleUrls: ['./exo4.component.scss']
})
export class Exo4Component {
  contactForm: FormGroup;
  constructor(private _fb: FormBuilder) {
    this.contactForm = this._fb.group({
      titre:[null,[Validators.required]],
      duree:[null,[Validators.required,Validators.min(0),Validators.max(360)]],
      album:[null],
      genre:['',[Validators.required]],
      artistes:this._fb.array([])
    })
  }
  addTrack(){
    if (this.contactForm.valid){
      console.log(this.contactForm.value);
    }else{
      this.contactForm.markAllAsTouched();
      console.log('not ok')
    }
  }
  get artistes(): FormArray{
    return this.contactForm.get('artistes') as FormArray;
  }
  addArtiste():void{
      this.artistes.push(this._fb.control(null,[Validators.required]));
  }
  removeArtiste(i: number){
    this.artistes.removeAt(i);
  }
}
