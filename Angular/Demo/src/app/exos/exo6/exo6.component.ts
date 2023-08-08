import {Component, OnInit} from '@angular/core';
import {Pokemon, pokemonSpecies} from "../../shared/models/Pokemon";
import {ListPokemon} from "../../shared/models/ListPokemon";
import {PokemonService} from "../../shared/services/pokemon.service";

@Component({
  selector: 'app-exo6',
  templateUrl: './exo6.component.html',
  styleUrls: ['./exo6.component.scss']
})
export class Exo6Component implements OnInit{
  ngOnInit(): void {
    this.currentOffset=0;
    this.getListPokemon(this.currentOffset);
  }
  currentOffset : number | undefined;
  currentPokemon! : Pokemon;
  listPokemon! : ListPokemon;
  pokemonSpecies!:pokemonSpecies;

  constructor(private _pokemonService : PokemonService) {
  }
  // @ts-ignore
  getListPokemon(offset : number):void{
    this._pokemonService.getOffSetPokemon(offset!).subscribe({
      next: (pokemonList) => {
        this.listPokemon = pokemonList;

      }
    });
    // @ts-ignore
    // for(let pokemon : Pokemon of this.listPokemon){
    //      pokemon.species = this.getPokemonSpecies(pokemon.id);
    // }
  }

  getListPokemonByUrl(url: string | undefined):void{
    this._pokemonService.getOffSetPokemonByUrl(url).subscribe({
      next: (pokemonList) => {
        this.listPokemon = pokemonList;

      }
    });
  }
  getPokemon(name: string):void{
    this._pokemonService.getOnePokemon(name).subscribe({
      next: (pokemon) => {
        this.currentPokemon = pokemon;
      }
    });
  }
}
