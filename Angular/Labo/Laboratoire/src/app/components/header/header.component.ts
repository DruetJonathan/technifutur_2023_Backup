import {Component, OnInit} from '@angular/core';
import {MemberService} from "../../services/member.service";
import {BehaviorSubject} from "rxjs";
import {Member} from "../../models/Member";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit{
  // @ts-ignore
  private connectedUser: Member;
  isAdmin: boolean = false;
  isConnected: boolean = false;
  changeMenuState() {
    const leftmenu = document.getElementById("leftMenu");
    // @ts-ignore
    const className = leftmenu.getAttribute("class");
    if (className === "isVisible") {
      // @ts-ignore
      leftmenu.classList.remove("isVisible");
      // @ts-ignore
      leftmenu.classList.add("notVisible");
    } else {
      // @ts-ignore
      leftmenu.classList.remove("notVisible");
      // @ts-ignore
      leftmenu.classList.add("isVisible");
    }
  }
  changeHeightSousList(){
    //todo faire animation sous menu
  }
  constructor(private _memberServ:MemberService,private _router:Router) {
  }
  getLogin(){
    return this.isConnected
  }

  ngOnInit(): void {
    this._memberServ.authSubject$.subscribe( (auth) => {
      this.isConnected = auth !== undefined;
      this.isAdmin = auth?.user.role === "Admin";
    } );
  }

  logout() {
    this._memberServ.logout();
    this._router.navigate(['/']);
  }
}
