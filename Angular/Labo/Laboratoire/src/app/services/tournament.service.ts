import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Tournament, TournamentDetails, TournamentIndex} from "../models/Tournament";
import {TournamentsComponent} from "../components/tournaments/tournaments.component";
import {FormGroup} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class TournamentService {
  url: string = "https://khun.somee.com/api/Tournament"

  getAllTournament(option:string):Observable<TournamentIndex>{
    console.log(this.url+option)
    return this._httpClient.get<TournamentIndex>(this.url+option);
  }
  getTournamentById(id:string):Observable<TournamentDetails>{
    console.log(this.url+"/"+id)
    return this._httpClient.get<TournamentDetails>(this.url+"/"+id);

  }
  addTournament(tournament:FormGroup){
    console.log(tournament)
    return this._httpClient.post(this.url,tournament)
  }

  constructor(private _httpClient : HttpClient) { }

  delete(index: string) {
    console.log(this.url+"/"+index)
    return this._httpClient.delete<string>(this.url+"/"+index)
  }
}
