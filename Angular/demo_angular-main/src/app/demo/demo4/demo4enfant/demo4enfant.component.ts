import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-demo4enfant',
  templateUrl: './demo4enfant.component.html',
  styleUrls: ['./demo4enfant.component.scss']
})
export class Demo4enfantComponent {
  // Input -> Pour recevoir des données du parent : On crée un "receptacle" dans lequel on va recevoir l'info
  @Input() parentFirstname : string = "";
  @Input() parentHobbies : string[] = [];

  // Output -> Pour envoyer des données au parent : On crée un évènement du type de la donnée qu'on souhaite envoyer
  @Output() sendNeed : EventEmitter<string> = new EventEmitter<string>();

  clickNeed(need : string) {
    this.sendNeed.emit(need);
  }
}
