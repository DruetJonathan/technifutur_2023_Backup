import {Injectable} from '@angular/core';
import {fanSerie} from "../models/fanSerie";
import {Track} from "../models/track";

@Injectable({
  providedIn: 'root'
})
export class FanSerieService {
  private _fanSerieList: fanSerie[] = [
    {
      id: 1,
      nom: 'Jonathan',
      ddn: new Date("2000-03-14"),
      series: ['Test', 'Coucou']

    },
  ];

  constructor() {
  }

  getAll(): fanSerie[] {
    return this._fanSerieList;
  }

  getById(id: number): fanSerie | undefined {
    return this._fanSerieList.find(fs => fs.id === id);
  }

  add(fanSerie: fanSerie): void {
    let maxId: number = Math.max(...this._fanSerieList.map(fs => fs.id));
    this._fanSerieList.length>0?fanSerie.id = maxId+1: fanSerie.id = 1;
    this._fanSerieList.push(fanSerie)
  }

  update(id: number, fanSerieUpdated: fanSerie): void {
    let found = this._fanSerieList.find(fs => fs.id === id);
    if (found) {
      Object.assign(found, fanSerieUpdated);
    }
  }

  delete(id: number): void {
    this._fanSerieList = this._fanSerieList.filter(fs => fs.id !== id);
  }
}
