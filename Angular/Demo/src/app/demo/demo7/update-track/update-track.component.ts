import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Track} from "../../../shared/models/track";
import {TrackService} from "../../../shared/services/track.service";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-update-track',
  templateUrl: './update-track.component.html',
  styleUrls: ['./update-track.component.scss']
})
export class UpdateTrackComponent implements OnInit, OnDestroy {

  trackId: number;
  track: Track | undefined;
  contactForm: FormGroup;


  constructor(private _fb: FormBuilder, private _activeRoute: ActivatedRoute, private _trackService: TrackService, private _router : Router) {
    this.trackId = parseInt(this._activeRoute.snapshot.params["id"]);
    this.contactForm = this._fb.group({
      titre: [null, [Validators.required]],
      duree: [null, [Validators.required, Validators.min(0), Validators.max(360)]],
      album: [null],
      genre: ['', [Validators.required]],
      artistes: this._fb.array([])
    })
  }

  ngOnInit(): void {
    console.log('init');
    this.track = this._trackService.getById(this.trackId);
    console.log(this.track);

    //? Ajouter un input pour chacun des artistes
    this.track?.artistes.forEach(a => this.addArtiste());

    // ? mettre a jour le formulaire
    this.contactForm.patchValue({
      titre: this.track?.titre,
      duree: this.track?.duree,
      album: this.track?.album,
      genre: this.track?.genre,
      artistes: this.track?.artistes
    })
  }

  ngOnDestroy() {
    console.log('destroy')
  }

  get artistes(): FormArray {
    return this.contactForm.get('artistes') as FormArray;
  }

  addArtiste(): void {
    this.artistes.push(this._fb.control(null, [Validators.required]));
  }

  removeArtiste(i: number) {
    this.artistes.removeAt(i);
  }

  updateTrack(): void {
    if (this.contactForm.valid) {
      this._trackService.update(this.trackId,this.contactForm.value);
      this._router.navigateByUrl('/demo/demo7')
    }else{
      this.contactForm.markAllAsTouched();
    }
  }
}
