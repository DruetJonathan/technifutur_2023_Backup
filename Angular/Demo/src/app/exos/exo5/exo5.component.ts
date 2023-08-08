import { Component } from '@angular/core';
import {fanSerie} from "../../shared/models/fanSerie";
import {TrackService} from "../../shared/services/track.service";
import {FanSerieService} from "../../shared/services/fan-serie.service";

@Component({
  selector: 'app-exo5',
  templateUrl: './exo5.component.html',
  styleUrls: ['./exo5.component.scss']
})
export class Exo5Component {
  _fanSerieList: fanSerie[];
  constructor(private _fanSerieService : FanSerieService) {
    this._fanSerieList = _fanSerieService.getAll();
  }

  delete(id: number) {
    this._fanSerieService.delete(id);
    this._fanSerieList = this._fanSerieService.getAll();
  }
}
