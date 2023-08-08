import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Form, FormGroup} from "@angular/forms";
import {BehaviorSubject, Observable, tap} from "rxjs";
import {Member, MemberFull} from "../models/Member";

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  url: string = "https://khun.somee.com/api/login";
  private readonly AUTH_KEY = 'auth';
  private _authSubject$: BehaviorSubject<MemberFull | undefined>
  constructor(private _httpClient : HttpClient) {
    this._authSubject$ = new BehaviorSubject<MemberFull | undefined>(this.authData)
  }

  login(login:FormGroup):Observable<MemberFull>{
    return this._httpClient.post<MemberFull>(this.url,login).pipe(
      tap( data => {
        sessionStorage.setItem(this.AUTH_KEY, JSON.stringify(data))
        this._authSubject$.next( this.authData )
      } )
    );
  }
  existsUsername(username:string){
    return this._httpClient.head("https://khun.somee.com/api/Member/existsUsername?Username="+username);
  }
  existsEmail(email:string){
    return this._httpClient.head("https://khun.somee.com/api/Member/existsEmail?Email="+email);
  }

  addNewMember(member:FormGroup){
    return this._httpClient.post("https://khun.somee.com/api/Member",member)
  }

  get authData(): MemberFull | undefined {
    const authDataString = sessionStorage.getItem(this.AUTH_KEY)
    if( !authDataString )
      return undefined;

    return JSON.parse(authDataString)
  }

  getLogin(){
    return sessionStorage.getItem(this.AUTH_KEY);
}

  logout() {
    sessionStorage.removeItem(this.AUTH_KEY)
    this._authSubject$.next( this.authData )
  }

  isAdmin() {
    return this.authData?.user.role === "Admin";
  }


  get authSubject$(): Observable<MemberFull | undefined> {
    return this._authSubject$.asObservable();
  }

  static isAdmin():boolean {
    return this.isAdmin();
  }

  changePassword(addform:FormGroup) {
    return this._httpClient.patch("https://khun.somee.com/api/Member"+"/password",addform)
  }
}
