import {Component} from '@angular/core';
import {TournamentService} from "../../../services/tournament.service";
import {AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {TournamentCategory} from "../../../models/Tournament";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-tournament',
  templateUrl: './add-tournament.component.html',
  styleUrls: ['./add-tournament.component.scss']
})
export class AddTournamentComponent {
  addForm: FormGroup;

  constructor(private _tournamentServ: TournamentService, private _fb: FormBuilder,private router: Router) {
    this.addForm = this._fb.group({
      name:[null,[Validators.required]],
      location:[null,[]],
      minPlayers:[null,[Validators.required,Validators.min(2)]],
      maxPlayers:[null,[Validators.required,Validators.max(16)]],
      eloMin:[null,[]],
      eloMax:[null,[]],
      categories:this._fb.array([
      ]),
      // categories:this._fb.array([null,[Validators.required]]),
      endOfRegistrationDate:[null,[Validators.required,dateSupAjdValidator()]],
      womenOnly:[false,[]],
    })
  }
  get categories(): FormArray{
    return this.addForm.get('categories') as FormArray;
  }
  addCategory(data : string) {
    this.categories.push(this._fb.control(data))
    console.log(this.categories)
  }
  addTournament() {
    console.log(this.addForm)
    if (this.addForm.valid){
      if (this.addForm.controls['eloMin'].value === null){
        this.addForm.controls['eloMin'].setValue(0);
      }
      if (this.addForm.controls['eloMax'].value === null){
        this.addForm.controls['eloMax'].setValue(3000);
      }
        // console.log(this.addForm.get('categories')?.value)
      this._tournamentServ.addTournament(this.addForm.value).subscribe()
      this.router.navigate(['/tournaments']);
    }
    else{
      this.addForm.markAllAsTouched();
    }
  }

  protected readonly TournamentCategory = TournamentCategory;


}

function dateSupAjdValidator(): ValidatorFn {
  return (control: AbstractControl): { [key: string]: any } | null => {
    if (!control.value) {
      // Si la valeur de contrôle est vide, la validation réussit (null)
      return null;
    }

    const dateAVerifier = new Date(control.value);
    const dateAjd = new Date();

    if (dateAVerifier >= dateAjd) {
      // La date est valide, donc la validation réussit (null)
      return null;
    } else {
      // La date est invalide, donc la validation échoue ({ dateSupAjd: true })
      return {dateSupAjd: true};
    }
  };
}
