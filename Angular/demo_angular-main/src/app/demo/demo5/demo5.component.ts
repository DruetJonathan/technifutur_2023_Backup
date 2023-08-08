import { Component } from '@angular/core';
import { User } from 'src/app/shared/models/user';
import { FakeAuthService } from 'src/app/shared/services/fake-auth.service';

@Component({
  selector: 'app-demo5',
  templateUrl: './demo5.component.html',
  styleUrls: ['./demo5.component.scss']
})
export class Demo5Component {
  connectedUser : User | undefined;

  login : string = "";
  password : string = "";

  constructor(private _fakeAuthS : FakeAuthService) {
  }

  connect() {
    this._fakeAuthS.login(this.login, this.password);
    this.connectedUser = this._fakeAuthS.connectedUser;
    this.login = "";
    this.password = "";
  }
  
  disconnect() {
    this._fakeAuthS.logout();
    this.connectedUser = this._fakeAuthS.connectedUser;

  }
}
