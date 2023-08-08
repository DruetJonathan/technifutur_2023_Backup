import { Component } from '@angular/core';
import {ThermometreService} from "../../observables/service/thermometre.service";
import {PanierService} from "../../observables/service/panier.service";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  private temperature!: number;
  bgClass = 'bg-gray'
  totalPrix!:number;
  constructor(private _thermoServ: ThermometreService, private _panierService : PanierService) {
    _thermoServ.temperatureSub.subscribe((temp) => {
      if( temp > this.temperature )
        this.bgClass = 'bg-red'
      else if ( temp < this.temperature )
        this.bgClass = 'bg-blue'
      else
        this.bgClass = 'bg-gray'

      this.temperature = temp
    })
    _panierService.panierSub.subscribe((prix)=>{this.totalPrix = prix})
  }


}
