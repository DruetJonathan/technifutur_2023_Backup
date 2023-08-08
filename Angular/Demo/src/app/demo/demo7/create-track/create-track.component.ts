import { Component } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Track} from "../../../shared/models/track";
import {TrackService} from "../../../shared/services/track.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-track',
  templateUrl: './create-track.component.html',
  styleUrls: ['./create-track.component.scss']
})
export class CreateTrackComponent {
  contactForm: FormGroup;
  constructor(private _fb: FormBuilder, private _trackService : TrackService, private _router : Router) {
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
      this._trackService.add(this.contactForm.value);
      this._router.navigateByUrl("demo/demo7")
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
