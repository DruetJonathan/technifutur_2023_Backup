import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {Login, Member} from "../models/Member";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url: string = "https://khun.somee.com/api/login"

  // auth():Observable<Login>{
  //   return this._httpClient.get<Login>(this.url);
  // }
  constructor(private _httpClient : HttpClient) { }

}
