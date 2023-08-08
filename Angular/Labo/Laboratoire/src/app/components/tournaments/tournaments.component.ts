import {Component, NgIterable, OnInit} from '@angular/core';
import {TournamentService} from "../../services/tournament.service";
import {Tournament, TournamentCategory, TournamentIndex, TournamentStatus} from "../../models/Tournament";
import {Observable, of} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpUrlEncodingCodec} from "@angular/common/http";
import {MemberService} from "../../services/member.service";

@Component({
  selector: 'app-tournaments',
  templateUrl: './tournaments.component.html',
  styleUrls: ['./tournaments.component.scss']
})
export class TournamentsComponent implements OnInit{
  listTournaments? : TournamentIndex ;
  searchForm : FormGroup;
  isAdmin : boolean = false;
  isConnected: boolean = false;
  constructor(private _tournamentServ : TournamentService,private _fb : FormBuilder,private _memberServ:MemberService) {
    this.searchForm = this._fb.group({
      name : [null],
      category : [null],
      status0:[null],
      status1:[null],
      status2:[null],
      womenOnly:[null],
    })
  }
  getAllTournaments(option : string){


      this._tournamentServ.getAllTournament(option === "" ? "?Statuses=WaitingForPlayers&Statuses=InProgress&Statuses=Closed" : option).subscribe(
        {
          next:(tournaments) =>
          {
            this.listTournaments = tournaments;
            console.log(this.listTournaments)
          }
        }
      );

  }

  ngOnInit(): void {
    this.getAllTournaments("");
    this._memberServ.authSubject$.subscribe( (auth) => {
      this.isConnected = auth !== undefined;
      this.isAdmin = auth?.user.role === "Admin";
    } );
  }

  updateTournamentList() {
    let option : string = "";
      if (this.searchForm.controls["name"].value !== null){
        // permet de transformer et d'encoder les espaces etc
        let codec= new HttpUrlEncodingCodec();
        let param = this.searchForm.controls["name"].value;
        let encodecParam = codec.encodeValue(param);
        option += '&Name='+encodecParam;
      }
    if (this.searchForm.controls["category"].value !== null){
      option += '&Category='+this.searchForm.controls["category"].value;
    }
    if (this.searchForm.controls["status0"].value !== null){
      option += '&Statuses=Closed';
    }
    if (this.searchForm.controls["status1"].value !== null){
      option += '&Statuses=InProgress';
    }
    if (this.searchForm.controls["status2"].value !== null){
      option += '&Statuses=WaitingForPlayers';
    }
    if (this.searchForm.controls["womenOnly"].value !== null){
      option += '&WomenOnly='+this.searchForm.controls["womenOnly"].value;
    }
    option = option.replace(option[0],"?");
    this.getAllTournaments(option);
  }
  deleteTournament(index:string){
    this._tournamentServ.delete(index).subscribe(
      {
        next:(deletedTournamentId:string) =>
        {
          console.log(deletedTournamentId)
          this.getAllTournaments("")
        }
      }
    )
  }

  protected readonly TournamentCategory = TournamentCategory;
  protected readonly TournamentStatus = TournamentStatus;
}
