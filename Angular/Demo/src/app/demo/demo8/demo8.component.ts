import {Component} from '@angular/core';
import {AgeInfo, GenreInfo, NationalityInfo} from "../../shared/models/nameInfo";
import {NameInfoService} from "../../shared/services/name-info.service";
import {CountryEnum} from "./CountryEnum";

@Component({
  selector: 'app-demo8',
  templateUrl: './demo8.component.html',
  styleUrls: ['./demo8.component.scss']
})
export class Demo8Component {
  nameAge: string = '';
  nameGenre: string = '';
  countryCodeAge: string = '';
  countryCodeGenre: string = '';
  nameNationality: string = '';
  age!: AgeInfo;
  genre!: GenreInfo;
  nationality!: NationalityInfo;

  constructor(private _nameInfoService: NameInfoService) {
  }

  predireAge(): void {
    if (this.nameAge.trim() !== '' && this.countryCodeAge !== '') {
      this._nameInfoService.getAge(this.nameAge, this.countryCodeAge).subscribe({
        next: (ageInfo) => {
          // Déclenché quand la requete est finie et qu'on a obtenu les infos
          this.age = ageInfo;
        },
        error: (err) => {
          console.log(err)
          //Déclecnhé si la requete produit une erreur
        },
        complete: () => {
          console.log('fini')
          // Se déclenche à la fin de la requête
        }
      })
    }
  }

  predireGenre(): void {
    if (this.nameGenre.trim() !== '' && this.countryCodeGenre !== '') {
      this._nameInfoService.getGender(this.nameGenre, this.countryCodeGenre).subscribe({
        next: (genreInfo) => {
          // Déclenché quand la requete est finie et qu'on a obtenu les infos
          this.genre = genreInfo;
        },
        error: (err) => {
          console.log(err)
          //Déclecnhé si la requete produit une erreur
        },
        complete: () => {
          console.log('fini')
          // Se déclenche à la fin de la requête
        }
      })

    }
  }
  predireNationalite(): void {
    if (this.nameNationality.trim() !== '') {
      this._nameInfoService.getNationality(this.nameNationality).subscribe({
        next: (nationality) => {
          // Déclenché quand la requete est finie et qu'on a obtenu les infos
          this.nationality = nationality;
        },
        error: (err) => {
          console.log(err)
          //Déclecnhé si la requete produit une erreur
        },
        complete: () => {
          console.log('fini')
          // Se déclenche à la fin de la requête
        }
      })

    }
  }
  getValueCountry(country_id:string):string{
    // const indexOfS = Object.values(CountryEnum).indexOf(country_id as unknown as CountryEnum);
    // const key = Object.keys(CountryEnum)[indexOfS];
    // return key;
    // @ts-ignore
    return CountryEnum[country_id];
  }

  protected readonly CountryEnum = CountryEnum;
}
