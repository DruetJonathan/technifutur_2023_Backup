import {Member} from "./Member";
import {Match} from "./Match";

export interface Tournament {
  id: string;
  name: string;
  location?: string;
  minPlayers: number;
  maxPlayers: number;
  eloMin?: number;
  eloMax?: number;
  categories?: TournamentCategory;
  womenOnly: boolean;
  endOfRegistrationDate: string;
  count: number;
  canRegister: boolean;
  isRegistered: boolean;
  status: TournamentStatus;
  currentRound: number;
}
export enum TournamentCategory{
  Junior= "Junior",
  Senior="Senior",
  Veteran="Veteran"
}
export enum TournamentStatus {
  WaitingForPlayers="WaitingForPlayers",
  InProgress="InProgress",
  Closed="Closed"
}
export interface TournamentIndex {
  total:number,
  results?:Tournament[]
}
export interface TournamentDetails {
  players: Member[],
  canStart : boolean,
  canValidateRound:boolean,
  matches:Match[]
  id: string;
  name: string;
  location?: string;
  minPlayers: number;
  maxPlayers: number;
  eloMin?: number;
  eloMax?: number;
  categories?: TournamentCategory[];
  womenOnly: boolean;
  endOfRegistrationDate: string;
  count: number;
  canRegister: boolean;
  isRegistered: boolean;
  status: TournamentStatus;
  currentRound: number;
}

export interface TournamentAdd {
  name:string,
  location:string,
  minPlayers:number,
  maxPlayers:number,
  eloMin:number,
  eloMax:number,
  categories:TournamentCategory,
  womenOnly:boolean,
  endOfRegistrationDate:string
}

