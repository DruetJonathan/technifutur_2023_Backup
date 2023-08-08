import { Component } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {BurgersService} from "../../../services/burgers.service";
import {Router} from "@angular/router";
import {BurgerApiService} from "../burger-api.service";

@Component({
  selector: 'app-add-burger-api',
  templateUrl: './add-burger-api.component.html',
  styleUrls: ['./add-burger-api.component.scss']
})
export class AddBurgerAPIComponent {
  burgerForm : FormGroup;

  constructor(private _fb : FormBuilder, private _burgerService : BurgerApiService, private _router : Router) {

    this.burgerForm = this._fb.group({
      //controlName : [value, [synchrone validators], [async validators]],
      name : [null, [Validators.required, Validators.maxLength(150)]],
      price : [null, [Validators.required, Validators.min(0)]],
      picture : [null, []],
      available : [false, []],
      ingredients : this._fb.array([

      ])
    });
  }

  get ingredients() : FormArray {
    return this.burgerForm.get('ingredients') as FormArray;
  }

  addIngredient() {
    this.ingredients.push(this._fb.control(null, [Validators.required]));
  }

  removeIngredient(i : number) {
    this.ingredients.removeAt(i)
  }
  errorShow?:boolean;
  addBurger() : void {
    if(this.burgerForm.valid) {

      this._burgerService.add(this.burgerForm.value).subscribe({
          next: (data) => console.log(data),
          error: (error)=> this.errorShow = true
        }
      );
      this._router.navigateByUrl('/observables');

    } else {

      this.burgerForm.markAllAsTouched();
    }
  }
}
