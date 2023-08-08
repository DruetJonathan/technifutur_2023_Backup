import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MemberService} from "../../../services/member.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent {
  addForm: FormGroup;

  constructor(private _memberServ: MemberService, private _fb: FormBuilder, private router: Router) {
    this.addForm = this._fb.group({
      oldPassword: [null, [Validators.required]],
      password: [null, [Validators.required]]
    });

  }

  changePassword() {
    if (this.addForm.valid){
      this._memberServ.changePassword(this.addForm.value).subscribe()
      this.router.navigateByUrl("/")
    }else{
      this.addForm.markAllAsTouched()
    }
  }
}
