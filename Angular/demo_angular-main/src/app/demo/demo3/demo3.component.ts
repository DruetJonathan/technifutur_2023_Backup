import { Component } from '@angular/core';
import { Trainer } from 'src/app/shared/models/trainers';

@Component({
  selector: 'app-demo3',
  templateUrl: './demo3.component.html',
  styleUrls: ['./demo3.component.scss']
})
export class Demo3Component {
  // ngStyle
  colors : string[] = ["green", "red", "blue", "yellow"];
  currentColor : number = 0;

  // ngClass
  isBig : boolean = false;
  isBold : boolean = false;
  isItalic : boolean = false;

  // ngIf
  apagnan : boolean = false;

  // ngFor 
  trainers : Trainer[] = [
    {id : 1, firstname : 'Gavin', lastname : 'Chaineux', birthdate : new Date(1993, 9, 18), gender : 'm', project : false, vacation : false, avatar : '/assets/images/gavin.png' },
    {id : 2, firstname : 'Seb', lastname : 'Bya', birthdate : new Date(1991, 2, 27), gender : 'm', project : false, vacation : false, avatar : '/assets/images/seb.png' },
    {id : 3, firstname : 'Aude', lastname : 'Beurive', birthdate : new Date(1989, 9, 16), gender : 'f', project : false, vacation : true, avatar : '/assets/images/aude.png' },
    {id : 4, firstname : 'Khun', lastname : 'Ly', birthdate : new Date(1982, 4, 6), gender : 'm', project : true, vacation : false, avatar : '/assets/images/khun.png' }
  ]

  // ngSwitch 
  drinkName : string = "";

  constructor() {
    //ngStyle
    setInterval(() => {
      this.currentColor++;
      if(this.currentColor > this.colors.length-1) this.currentColor = 0;
    }, 2000)
  }

  //ngClass
  toggleBig() : void {
    this.isBig = !this.isBig;
  }
  toggleBold() : void {
    this.isBold = !this.isBold;
  }
  toggleItalic() : void {
    this.isItalic = !this.isItalic;
  }

  // ngIf
  toggleApagnan() : void {
    this.apagnan = !this.apagnan;
  }
}
