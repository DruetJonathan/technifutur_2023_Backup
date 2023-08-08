import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { last } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FakeAuthService {

  // Normalement on fait appel à la db, pour l'instant on n'a pas encore appris donc on fait une liste privée qui sera notre fakedb
  private _users : User[] = [
    { id : 1, lastname : 'Ly', firstname : 'Khun', pseudo : 'kly', email : 'khun.ly@bstorm.be', password : 'Khun1234='},
    { id : 2, lastname : 'Bya', firstname : 'Seb', pseudo : 'sbya', email : 'sebastien.bya@bstorm.be', password : 'Seb1234='}
  ]

  connectedUser : User | undefined;

  constructor() { }

  login(login : string, pwd : string) : void {
    // login contient soit pseudo, soit email, donc on cherche les deux
    let userToFind = this._users.find(u => u.pseudo === login || u.email === login);
    //Si on a trouvé un user qui correspond, on check son pwd
    if(userToFind) {
      if(userToFind.password === pwd) {
        this.connectedUser = userToFind;
      }
      else {
        this.connectedUser = undefined;
      }
    }
    else {
      this.connectedUser = userToFind; //undefined
    }
  }

  logout() : void {
    this.connectedUser = undefined;
  }
}
