import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerForm : FormGroup;
  constructor(private _fb : FormBuilder) {
    this.registerForm = this._fb.group({
      "lastname" :[null,[Validators.required,
        Validators.maxLength(100),
      Validators.pattern(/\D+/)]],
      "firstname" : [null,[Validators.required,
        Validators.pattern(/\D+/)]],
      "pseudo" : [null,[Validators.required,
      Validators.maxLength(100)]],
      "email" : [null,[Validators.required,Validators.email]],
      "password" : [null,[Validators.required,Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/
      )]],
      "confirmPassword" : [null,[Validators.required,
        Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/
        )]]
    })
  }
}
