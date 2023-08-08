import { Component } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-demo6',
  templateUrl: './demo6.component.html',
  styleUrls: ['./demo6.component.scss']
})
export class Demo6Component {
  contactForm : FormGroup;
  countries : string[] = ["belgique","allemagne","france"];


  constructor(private _fb : FormBuilder) {
    this.contactForm = this._fb.group({
      //nomControl : [valeur, [Validateurs synchrones] , [Validateurs asynchrones]]
      //password : [null, [Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/)]]
      lastname : [null, [ Validators.required, Validators.minLength(2), Validators.maxLength(100) ]],
      firstname : [null, [ Validators.required, Validators.minLength(2), Validators.maxLength(100) ]],
      birthdate : [null, [ Validators.required ]],
      email : [null, [Validators.required, Validators.email]],
      height : [null, [Validators.min(50), Validators.max(230)]],
      couple : [false],
      gender : ['male', [Validators.required]],
      type : ['', [Validators.required]],
      country : [null, [Validators.required, this.countryValidator()]],
      hobbies : this._fb.array([
        this._fb.control(null, Validators.required)
      ])
    })
  }

  //Renverra le control qui s'appelle hobbies, qui est un tableau de controls
  //On s'en servira pour boucler dessus
  get hobbies() : FormArray {
    return this.contactForm.get('hobbies') as FormArray;
  }

  addHobby() {
    this.hobbies.push(this._fb.control(null, Validators.required))
  }

  removeHobby(i : number) {
    this.hobbies.removeAt(i);
  }

  addContact() {
    if(this.contactForm.valid) {
      console.log(this.contactForm.value);
    } else {
      console.log("PAS VALIDE !!");
      //Tous les controls vont être touched
      //Du coup toutes nos erreurs requis vont apparaitre
      this.contactForm.markAllAsTouched();
    }    
  }

  countryValidator() : ValidatorFn | null {
    return (control : AbstractControl) => {
      if(control.value && !this.countries.includes(control.value?.trim().toLowerCase())){
        //erreur
        return { invalidcountry : true }
      }
      return null;
    }
  }
}
