import { Component } from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormGroup, ValidatorFn, Validators} from '@angular/forms';

@Component({
  selector: 'app-demo6',
  templateUrl: './demo6.component.html',
  styleUrls: ['./demo6.component.scss']
})
export class Demo6Component {
  contactForm: FormGroup;
  countries :string[] = ["belgique","allemagne","irlande"];
  constructor(private _fb: FormBuilder) {
    this.contactForm = this._fb.group({
      // ?  nomControl: [valeur,[validateur synchrones],[validateur asynchrones]]
      lastname: [null,[Validators.required,Validators.minLength(2),Validators.maxLength(100)]],
      firstname: [null,[Validators.required,Validators.maxLength(100)]],
      birthdate: [null,[Validators.required]],
      email: [null,[Validators.required,Validators.email]],
      height: [null,[Validators.min(50),Validators.max(250)]],
      couple: [null],
      gender: ['homme',[Validators.required]],
      type: ['',[Validators.required]],
      hobbies: this._fb.array([]),
      country:[null,[Validators.required,this.countryValidator()]]
      // ! password: [null, [Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/)]]
    })
  }
  get hobbies() : FormArray{
    return this.contactForm.get('hobbies') as FormArray
  }
  addContact(): void {
    if (this.contactForm.valid){
      console.log(this.contactForm.value);
    }else{
      this.contactForm.markAllAsTouched();
      console.log('not ok')
    }

  }
  addHobby(){
    this.hobbies.push(this._fb.control(null,[Validators.required]));
  }
  removeHobby(i: number){
    this.hobbies.removeAt(i);
  }
  countryValidator():ValidatorFn | null{
    return (control : AbstractControl) => {
      if (control.value && !this.countries.includes(control.value?.trim().toLowerCase())){
        return {invalidcountry : true};
      }
      return null;
    };
  }
}
