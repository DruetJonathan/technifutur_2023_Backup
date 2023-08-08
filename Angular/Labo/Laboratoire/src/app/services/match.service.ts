import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Match} from "../models/Match";

@Injectable({
  providedIn: 'root'
})
export class MatchService {
  url: string = "https://khun.somee.com/api/Match"

  // getMatch():Observable<Match[]>{
  //   return this._httpClient.get<Match[]>(this.url);
  // }
  getMatchById(id:string,round:string):Observable<Match[]>{
    console.log(this.url+"?tournamentId="+id+"&round="+round)
    return this._httpClient.get<Match[]>(this.url+"?tournamentId="+id+"&round="+round);
  }
  constructor(private _httpClient : HttpClient) { }
}
