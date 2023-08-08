import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AgeInfo, GenreInfo, NationalityInfo} from "../models/nameInfo";

@Injectable({
  providedIn: 'root'
})
export class NameInfoService {
  private _urlGender : string='https://api.genderize.io/'
  private _urlAge : string='https://api.agify.io/'
  private _urlNationality : string='https://api.nationalize.io/'
  constructor(private _httpClient : HttpClient) { }

  getGender(name:string,countryCode:string):Observable<GenreInfo>{
    return this._httpClient.get<GenreInfo>(this._urlGender+`?name=${name}&country_id=${countryCode}`);
  }

  getAge(name:string,countryCode:string):Observable<AgeInfo>{
    return this._httpClient.get<AgeInfo>(this._urlAge+`?name=${name}&country_id=${countryCode}`);
  }

  getNationality(name:string):Observable<NationalityInfo>{
    return this._httpClient.get<NationalityInfo>(this._urlNationality+`?name=${name}`);

  }
}
