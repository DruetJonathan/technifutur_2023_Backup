import { Component } from '@angular/core';

@Component({
  selector: 'app-demo1',
  templateUrl: './demo1.component.html',
  styleUrls: ['./demo1.component.scss']
})
export class Demo1Component {
    firstname : string = "Aude";

    lastname : string = "";

    message : string = "[... en attente d'un bonjour ...]";
    
    isActive : boolean = false;

    monPlaceholder : string = "Pouet";

    monUrlImg : string = "./assets/images/coubeh.jpg";

    direBonjour(langue : string) : void {
      switch(langue) {
        case 'fr' :
          this.message = "Bonjour !";
          break;
        case 'nl' :
          this.message = "Goedendag !";
          break;
        case 'de' :
          this.message = "Guten Tag !";
          break;
        default :
          this.message = "Quoi ?";
          break;
      }
    }

    toggleIsActive() : void {
      this.isActive = !this.isActive;
    }
}
