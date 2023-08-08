import {Component} from '@angular/core';
import {TournamentService} from "../../../services/tournament.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MemberService} from "../../../services/member.service";

@Component({
  selector: 'app-new-member',
  templateUrl: './new-member.component.html',
  styleUrls: ['./new-member.component.scss']
})
export class NewMemberComponent {
  addForm: FormGroup;
  existUsernameValue: boolean | undefined = false;
  existEmailValue: boolean | undefined = false;

  constructor(private _memberServ: MemberService, private _fb: FormBuilder, private router: Router) {
    this.addForm = this._fb.group({
      username: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      birthDate: [null, [Validators.required]],
      elo: [0, [Validators.required, Validators.min(0), Validators.max(3000)]],
      gender: [null, [Validators.required]],
    })
  }

  addMember() {
    if (this.addForm.valid) {
      console.log(this.addForm.value)
      this._memberServ.addNewMember(this.addForm.value).subscribe()
      this.router.navigate(['/']);
    } else {
      this.addForm.markAllAsTouched()
    }
  }

  existsUsername() {
    this._memberServ.existsUsername(this.addForm.get('username')?.value).subscribe({
      next: (data: Object) => {
        // si existe
        this.existUsernameValue = true;
      },
      error: (error: Object) => {
        this.existUsernameValue = false;
      }
    })
  }
  existsEmail() {
    this._memberServ.existsEmail(this.addForm.get('email')?.value).subscribe({
      next: (data: Object) => {
        // si existe
        this.existEmailValue = true;
      },
      error: (error: Object) => {
        this.existEmailValue = false;
      }
    })
  }
}
