import { Component } from '@angular/core';

@Component({
  selector: 'app-demo1',
  templateUrl: './demo1.component.html',
  styleUrls: ['./demo1.component.scss']
})
export class Demo1Component {
  firstname: String = "Jonathan";
  lastname: String = "";
  message: String = "[... en attente d'un bonjour ...]";
  isActive: Boolean = false;
  monUrlImg: String = "../../../assets/images/P0050025.JPG";
  direBonjour(langue: String): void {
    switch (langue) {
      case 'fr':
        this.message = "Bonjour !";
        break;
      case 'nl':
        this.message = "Goedendag !";
        break;
      case 'de':
        this.message = "Gutan Tag";
        break;
      default:
        this.message = "Quoi ?";
        break;
    }
  }
  toggleIsActive(): void {
    this.isActive = !this.isActive;
  }
}
