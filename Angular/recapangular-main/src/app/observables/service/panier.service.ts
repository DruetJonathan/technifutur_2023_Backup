import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PanierService {
  private _panier : number= 0;
  private _panierSub : BehaviorSubject<number> = new BehaviorSubject<number>(this._panier)

  constructor() { }

  get panier(): number{
    return this._panier;
  }

  set panier(value: number) {
    this._panier = value;
    this._panierSub.next(this._panier)
  }

  get panierSub(){
    return this._panierSub.asObservable();
  }
}
