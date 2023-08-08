import { Component } from '@angular/core';
import {TournamentService} from "../../../services/tournament.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MemberService} from "../../../services/member.service";
import {Observable} from "rxjs";
import {MemberFull} from "../../../models/Member";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm:FormGroup;
  constructor(private _memberServ:MemberService,private _fb : FormBuilder,private _router:Router) {
    this.loginForm = this._fb.group({
      username : [null,[Validators.required]],
      password : [null,[Validators.required]]
    });
  }
  login(){
    if (this.loginForm.valid){
      this._memberServ.login(this.loginForm.value).subscribe({
        next: (result) => console.log(result)
      });
      this._router.navigateByUrl("/")
    }
    else{
      this.loginForm.markAllAsTouched()
    }
  }
}
