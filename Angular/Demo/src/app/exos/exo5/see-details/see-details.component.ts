import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {FanSerieService} from "../../../shared/services/fan-serie.service";
import {fanSerie} from "../../../shared/models/fanSerie";

@Component({
  selector: 'app-see-details',
  templateUrl: './see-details.component.html',
  styleUrls: ['./see-details.component.scss']
})
export class SeeDetailsComponent {
  id : number;
  fanSerie! : fanSerie;
  constructor(private _activeRoute : ActivatedRoute,private _fanSerieService : FanSerieService) {
    this.id = parseInt(this._activeRoute.snapshot.params["id"]);
    this.fanSerie = _fanSerieService.getById(this.id)!;
  }
}
