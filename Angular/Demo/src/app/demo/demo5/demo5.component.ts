import {Component, OnDestroy, OnInit} from '@angular/core';
import { User } from 'src/app/shared/models/user';
import { FakeAuthService } from 'src/app/shared/services/fake-auth.service';
import {Subscription} from "rxjs";

@Component({
  selector: 'app-demo5',
  templateUrl: './demo5.component.html',
  styleUrls: ['./demo5.component.scss']
})
export class Demo5Component
  implements OnInit,OnDestroy{
  ngOnInit(): void {
    this.userSubscription = this._fakeAuthS.$connectedUser.subscribe({
      next : (newUser : User | undefined) =>{
          // se declenche quand notre observable va changer de valeur
        console.log("next déclanché dans démo5: ",newUser)
        this.connectedUser = newUser;
      },
      error : (error) =>{
         //se declenche quand l'observable va rencontré une error

        // ! elle met fin à l'observable
      },
      complete : () =>{
        //se declenche à la fin de vie de l'observable
      }
    });
    // si on a qu'une fonction fleché dans le subscribe au lieu d'un objet, c'est d'office le next
    // this._fakeAuthS.$connectedUser.subscribe((newUser)=>{})
  }
  userSubscription : Subscription = new Subscription();
  ngOnDestroy(): void {
    this.userSubscription.unsubscribe();
  }
  connectedUser: User | undefined;
  login: string = "";
  password: string = "";

  constructor(private _fakeAuthS: FakeAuthService) {
  }
  connect(): void {
    this._fakeAuthS.login(this.login, this.password)
    // this.connectedUser = this._fakeAuthS.connectedUser;
    this.login = "";
    this.password = "";
  }
  disconnect(): void {
    this._fakeAuthS.logout();
    // this.connectedUser = this._fakeAuthS.connectedUser;

  }


}
