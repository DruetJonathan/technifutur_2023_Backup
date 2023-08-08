import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-demo4-enfant',
  templateUrl: './demo4-enfant.component.html',
  styleUrls: ['./demo4-enfant.component.scss']
})
export class Demo4EnfantComponent {
  // ? Input pour recevoir des données du parent: on crée un "receptacle" dans lequel on va recevoir l'info
  @Input() parentFirstname: string = "";
  @Input() parentHobbies: string[] = [];

  // ? Output ->
  @Output() sendNeed: EventEmitter<string> = new EventEmitter<string>();

  clickNeed(need: string) {
    this.sendNeed.emit(need);
  }
}
