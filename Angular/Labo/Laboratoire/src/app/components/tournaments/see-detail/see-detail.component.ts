import {Component, OnInit} from '@angular/core';
import {TournamentService} from "../../../services/tournament.service";
import {TournamentDetails, TournamentIndex} from "../../../models/Tournament";
import {ActivatedRoute} from "@angular/router";
import {Match} from "../../../models/Match";
import {MatchService} from "../../../services/match.service";

@Component({
  selector: 'app-see-detail',
  templateUrl: './see-detail.component.html',
  styleUrls: ['./see-detail.component.scss']
})
export class SeeDetailComponent implements OnInit{
  tournament? : TournamentDetails ;
  match? : Match;

  id : String = "";
  round:number=0;
  constructor(private _tournamentServ: TournamentService,private _matchServ:MatchService,private _route: ActivatedRoute) {
  }

  ngOnInit(): void {
    // @ts-ignore
    this.id = this._route.snapshot.paramMap.get('id');
    // @ts-ignore
    this.getTournamentById(this.id);
    // @ts-ignore
    this.getMatch(this.id,this.round);

  }

  private getTournamentById(id:string) {
    this._tournamentServ.getTournamentById(id).subscribe(
      {
        next:(tournament) =>
        {
          this.tournament = tournament;
        }
      }
    );

  }
  private getMatch(id:string,round:string) {
    this._matchServ.getMatchById(id,round+1).subscribe(
      {
        next:(match) =>
        {
          console.log(match)
          this.match = match[0];
        }
      }
    );

  }

  changeRound(number: number) {
    this.round = number;
  }
}
