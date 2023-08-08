import { Component } from '@angular/core';

@Component({
  selector: 'app-bases',
  templateUrl: './bases.component.html',
  styleUrls: ['./bases.component.scss']
})
export class BasesComponent {
  // BINDINGS -----------------------
  name : string = 'Bob';

  eventMsg : string = 'Click on the button';

  imgSource : string = 'https://uploads.dailydot.com/2018/10/olli-the-polite-cat.jpg';

  clickMe() : void  {
    this.eventMsg = 'You clicked me 👉👈';
  }

  // PIPES --------------------------

  today : Date = new Date();

  // DIRECTIVES ---------------------
  isNight : boolean = false;
  toggleDayNight() : void {
    this.isNight = !this.isNight;
  }

  connected : boolean = false;
  login() : void {
    this.connected = true;
  }
  logout() : void {
    this.connected = false;
  }

  topWorstDriver : string[] = ['Français', 'Hollandais', 'Suisse'];

  // INPUT/OUTPUT --------------------
  foodType : string = '';
  setFoodType(type : string) : void {
    this.foodType = type;
    this.todayMeal = '';
  }
  todayMeal : string = '';

  changeMeal(meal : string) : void {
    this.todayMeal = meal;
  }
}
