import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pokemon, pokemonSpecies} from "../models/Pokemon";
import {ListPokemon} from "../models/ListPokemon";

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private _urlPokemon : string='https://pokeapi.co/api/v2/'

  getOnePokemon(namePokemon : string):Observable<Pokemon>{
    return this._httpClient.get<Pokemon>(this._urlPokemon+`pokemon/${namePokemon}`)
  }
  getOffSetPokemon(offset : number):Observable<ListPokemon>{
    return this._httpClient.get<ListPokemon>(this._urlPokemon+`pokemon/?limit=20&offset=${offset}`)
  }

  getOffSetPokemonByUrl(url: string | undefined):Observable<ListPokemon>{
    return this._httpClient.get<ListPokemon>(<string>url);
  }
  getPokemonSpecies(id:number){
    return this._httpClient.get<Pokemon>(this._urlPokemon+`pokemon-species/${id}`)
  }
  constructor(private _httpClient : HttpClient) { }
}
