import {lightPokemon, Pokemon} from "./Pokemon";

export interface ListPokemon {
  results : lightPokemon[],
  next?: string,
  previous?: string,
}
