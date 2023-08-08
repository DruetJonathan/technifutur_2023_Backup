import { Injectable } from '@angular/core';
import { Track } from '../models/track';

@Injectable({
  providedIn: 'root'
})
export class TrackService {

  private _trackList : Track[] = [
    { id : 1, title : 'Broken Smile', duration : 280, album : 'Come Over When You\'re Sober', genre : 'Musique de dépressif', artists : ['Lil Peep']},
    { id : 2, title : 'Me faire la belle', duration : 213, album : 'Bohemian Rap Story', genre : 'Rap', artists : ['Dooz Kawa']}
  ]

  constructor() { }

  getAll() : Track[] {
    return this._trackList;
  }

  getById(id : number) : Track|undefined {
    return this._trackList.find(t => t.id === id);
  }

  add(trackToAdd : Track) : void { 
    trackToAdd.id = Math.max( ...this._trackList.map(t => t.id)) + 1;;
    this._trackList.push(trackToAdd);
  }
  
  update(id : number, trackUpdated : Track) : void {
    let found : Track|undefined = this._trackList.find(t => t.id === id)
    if(found) {
      found = {...trackUpdated};
    }
  }

  delete(id : number) {
    this._trackList = this._trackList.filter(t => t.id !== id);
  }
}
