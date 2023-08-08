import { Injectable } from '@angular/core';
import { User } from '../models/user';
import {BehaviorSubject, Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FakeAuthService {
  //! fakeDb
  private _users: User[] = [
    {
      id: 1, lastname: 'jona', firstname: 'dru', pseudo: 'test', email: 'j.dru@gmail.com', password: '1234'
    },
    {
      id: 2, lastname: 'bya', firstname: 'seb', pseudo: 'seb.bya', email: 'seb.bya@gmail.com', password: '4321'
    }
  ];

  constructor() { }
  // private _$connectedUser : Subject<User|undefined> = new Subject<User | undefined>();
  private _$connectedUser : BehaviorSubject<User|undefined> = new BehaviorSubject<User|undefined>
  (this._users.find(u => u.id === parseInt(localStorage.getItem('userId')?? "-1")))
  $connectedUser : Observable<User| undefined> = this._$connectedUser.asObservable();

  login(login: string, pwd: string): void {
    console.log("ok");
    // ? login contient soit pseudo, soit email, donc on cherche les deux
    let userToFind = this._users.find(u => u.pseudo === login || u.email === login);
    // si on a toruvé un user qui correspond, on check son pwd
    if (userToFind) {
      if (userToFind.password === pwd) {
        //? avant observable
        // this.connectedUser = userToFind;
        // ? apres observable
        this._$connectedUser.next(userToFind)
        //ajout de son id dna sle localstorage
        localStorage.setItem('userId',userToFind.id.toString())
      }
      else {
        //? avant observable
        // this.connectedUser = undefined;
        // ? apres observable
        this._$connectedUser.next(undefined);
      }
    }
    else {
      //? avant observable
      // this.connectedUser = userToFind; // undefined si non trouvé
      // ? apres observable
      this._$connectedUser.next(userToFind)
    }
  }
  logout(): void {
    //? avant observable
    // this.connectedUser = undefined;
    // ? apres observable
    console.log("logout")
    this._$connectedUser.next(undefined);
    localStorage.removeItem('userId')
  }

}
