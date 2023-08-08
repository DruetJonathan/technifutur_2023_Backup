import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Burger} from "../../services/burger";
import {Observable} from "rxjs";

@Injectable()
export class BurgerApiService {

  private readonly BASE_URL = 'http://localhost:3000/burgers'

  constructor(private _client: HttpClient) { }

  getBurgers(): Observable<Burger[]> {
    return this._client.get<Burger[]>(this.BASE_URL)
  }

  addBurger(burger: Burger) {
    return this._client.post<Burger>(this.BASE_URL, burger)
  }

}
