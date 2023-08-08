import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';
import { TrackService } from 'src/app/shared/services/track.service';

@Component({
  selector: 'app-create-track',
  templateUrl: './create-track.component.html',
  styleUrls: ['./create-track.component.scss']
})
export class CreateTrackComponent {
  trackForm : FormGroup;

  constructor(private _fb : FormBuilder, private _trackService : TrackService, private _router : Router) {
    this.trackForm = this._fb.group({
      title : [null, [Validators.required]],
      duration : [null, [Validators.required, Validators.min(0), Validators.max(600)]],
      album : [null],
      genre : ['', [Validators.required]],
      artists : this._fb.array([
        this._fb.control(null, Validators.required)
      ])
    })
  }

  //getter 
  get artists() : FormArray {
    return this.trackForm.get('artists') as FormArray;
  }
  
  addArtist() : void {
    this.artists.push(this._fb.control(null, Validators.required))
  }
  removeArtist(i : number) : void {
    this.artists.removeAt(i);
  }

  addTrack() : void {
    if(this.trackForm.valid) {
      console.log(this.trackForm.value);
      this._trackService.add(this.trackForm.value);
      this._router.navigateByUrl('/demo/demo7'); //Permet de rediriger vers la route demo/demo7
    }
    else {
      console.log("PAS VALIDE");
      this.trackForm.markAllAsTouched();
      
    }
  }
}
