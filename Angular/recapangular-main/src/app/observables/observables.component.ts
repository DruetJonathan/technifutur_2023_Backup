import { Component } from '@angular/core';
import {catchError, delay, EMPTY, empty, interval, Observable, of, startWith, switchMap, tap} from 'rxjs'
import {BurgerApiService} from "./service/burger-api.service";
import {Burger} from "../services/burger";
import {PanierService} from "./service/panier.service";

@Component({
  selector: 'app-observables',
  templateUrl: './observables.component.html',
  styleUrls: ['./observables.component.scss']
})
export class ObservablesComponent {

  obsCold$ = of( 1,2,3,4,5 );
  // obsHot$ = interval(1000)

  burgers$?: Observable<Burger[]>;
  lastReception?: Date;

  constructor(private _burgerServ: BurgerApiService,private _panierService : PanierService) {
    this.demoSub();

    // _burgerServ.getBurgers().subscribe( (data: Burger[]) => this.burgers = data )

    // this.burgers$ = _burgerServ.getBurgers();

    // this.burgers$ = _burgerServ.getBurgers().pipe(
    //   delay(1000),
    //   tap((data) => console.log(data)), // reaction au signal 'next'
    //   catchError((err) => { // reaction au signal 'error'
    //     console.warn(err);
    //     return EMPTY;
    //   })
    // );

    this.burgers$ = interval(60_000).pipe(
      startWith(0),
      switchMap( (data) => _burgerServ.getBurgers() ), // à chaque émission, transforme l'observable
      delay(1000), // ajoute un délai à chaque émission 'next'
      tap((data) => this.lastReception = new Date() ), // reaction au signal 'next'
      catchError((err) => { // reaction au signal 'error'
        console.warn(err);
        return EMPTY;
      })
    );
    this._panierService.panierSub.subscribe((prix) => this.totalPrix = prix)

  }


  demoSub() {
    this.obsCold$.subscribe( {
      next: (data) => console.log(data),
      // error: (error) => console.log(error),
      complete: () => console.log("FIN")
    } )
    this.obsCold$.subscribe( {
      next: (data) => console.log(data),
      // error: (error) => console.log(error),
      complete: () => console.log("FIN")
    })
  }

  totalPrix!:number;
  addPanier(prix:number) {
    this._panierService.panier += +prix;
  }
}
