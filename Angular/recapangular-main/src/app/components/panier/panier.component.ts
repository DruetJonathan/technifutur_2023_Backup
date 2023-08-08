import { Component } from '@angular/core';
import {PanierService} from "../../observables/service/panier.service";

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent {

  totalPrix! : number;
  constructor(private _panierService : PanierService) {
    this._panierService.panierSub.subscribe((prix) => this.totalPrix = prix)

  }
}
