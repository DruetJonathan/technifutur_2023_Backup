import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-exo4',
  templateUrl: './exo4.component.html',
  styleUrls: ['./exo4.component.scss']
})
export class Exo4Component {
  // Titre de la chanson (requis)
  // Durée (number en secondes) (requis, min, max)
  // Album (optionnel)
  // Genre (select avec plusieurs genres) (requis)
  // Artistes :
  // Ajouter plein d'artistes
  trackForm : FormGroup;

  constructor(private _fb : FormBuilder) {
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
      
    }
    else {
      console.log("PAS VALIDE");
      this.trackForm.markAllAsTouched();
      
    }
  }
}
