export interface  GenreInfo{
  count:number;
  name:string;
  country_id:string;
  gender:string;
  probability:number;
}
export interface  AgeInfo{
  count:number;
  name:string;
  country_id:string;
  age:number;
}
export interface  NationalityInfo{
  name:string;
  country : Country[];
}
export interface Country{
  country_id : string;
  probability : number;
}
