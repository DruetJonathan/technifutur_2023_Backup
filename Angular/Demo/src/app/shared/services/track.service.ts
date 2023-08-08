import {Injectable} from '@angular/core';
import {Track} from "../models/track";

@Injectable({
  providedIn: 'root'
})
export class TrackService {
  private _tracklist: Track[] = [
    {
      id: 1,
      titre: 'Broken Smile',
      duree: 281,
      album: 'Come Over when you are sober',
      genre: 'RNB',
      artistes: ['Lil Peep']
    },
    {
      id: 2, titre: 'Me faire la belle', duree: 213, album: 'Bohemian Rap Story', genre: 'RNB', artistes: ['Dooz kawa']
    }
  ];

  constructor() {
  }

  getAll(): Track[] {
    return this._tracklist;
  }

  getById(id: number): Track | undefined {
    return this._tracklist.find(t => t.id === id);
  }

  add(track: Track): void {
    let maxId : number = Math.max( ...this._tracklist.map(t=>t.id));
    track.id = maxId+1;
    this._tracklist.push(track)
  }

  update(id:number,trackUpdated: Track): void {
    let found = this._tracklist.find(t=> t.id===id);
    if (found){
      // found.titre = trackUpdated.titre;
      // found.duree = trackUpdated.duree;
      // found.genre = trackUpdated.genre;
      // found.album = trackUpdated.album;
      // found.artistes = trackUpdated.artistes;
      Object.assign(found,trackUpdated);
    }
  }

  delete(id : number): void {
    this._tracklist = this._tracklist.filter(t=> t.id !== id);
  }
}
