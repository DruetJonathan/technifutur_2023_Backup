export interface Pokemon {
  id : number;
  name:string;
  weight:number;
  height:number,
  sprites:sprites,
  species: pokemonSpecies
  color:string;
}
export interface lightPokemon {
  name:string;
  url:string;
  color:string;
}
export interface sprites {
  back_default: string,
  front_default: string
}
export interface pokemonSpecies {
  color:colorPokemon,
}
export interface colorPokemon{
  name:string;
  url:string;
}
