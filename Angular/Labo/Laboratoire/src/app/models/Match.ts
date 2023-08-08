export interface Match {
  id:number,
  tournamentId:string,
  blackName?:string,
  blackId:string,
  whiteName?:string,
  whiteId:string,
  result:MatchResult,
  round:number
}

export enum MatchResult {
  NotPlayed="NotPlayed",
  WhiteWin="WhiteWin",
  BlackWin="BlackWin",
  Draw="Draw"
}
