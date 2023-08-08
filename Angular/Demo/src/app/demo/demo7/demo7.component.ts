import { Component } from '@angular/core';
import {Track} from "../../shared/models/track";
import {TrackService} from "../../shared/services/track.service";

@Component({
  selector: 'app-demo7',
  templateUrl: './demo7.component.html',
  styleUrls: ['./demo7.component.scss']
})
export class Demo7Component {
  listTrack : Track[]=[];

  constructor(private _trackService : TrackService) {
    this.listTrack = _trackService.getAll();
  }

  delete(id:number):void{
    this._trackService.delete(id);
    this.listTrack = this._trackService.getAll();
  }
}
