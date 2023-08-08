import { Component } from '@angular/core';
import { Trainer } from 'src/app/shared/models/trainers';

@Component({
  selector: 'app-demo4',
  templateUrl: './demo4.component.html',
  styleUrls: ['./demo4.component.scss']
})
export class Demo4Component {
  firstname : string = "Roger";
  hobbies : string[] = ["Pétanque", "Ricard", "OnePiece"];

  childNeed : string = "...[Ne sait pas ce qu'il veut]...";

  trainers : Trainer[] = [
    {id : 1, firstname : 'Gavin', lastname : 'Chaineux', birthdate : new Date(1993, 9, 18), gender : 'm', project : false, vacation : false, avatar : '/assets/images/gavin.png' },
    {id : 2, firstname : 'Seb', lastname : 'Bya', birthdate : new Date(1991, 2, 27), gender : 'm', project : false, vacation : false, avatar : '/assets/images/seb.png' },
    {id : 3, firstname : 'Aude', lastname : 'Beurive', birthdate : new Date(1989, 9, 16), gender : 'f', project : false, vacation : true, avatar : '/assets/images/aude.png' },
    {id : 4, firstname : 'Khun', lastname : 'Ly', birthdate : new Date(1982, 4, 6), gender : 'm', project : true, vacation : false, avatar : '/assets/images/khun.png' }
  ]

  trainerOfTheDay! : Trainer;

  receiveNeed(need : string) : void {
    this.childNeed = need;
  }

  changeTrainer(trainer : Trainer) : void {
    this.trainerOfTheDay = trainer;
  }
}
