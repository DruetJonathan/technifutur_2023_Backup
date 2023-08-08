import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Trainer } from 'src/app/shared/models/trainers';

@Component({
  selector: 'app-trainer-card',
  templateUrl: './trainer-card.component.html',
  styleUrls: ['./trainer-card.component.scss']
})
export class TrainerCardComponent {
  @Input() trainer! : Trainer;

  @Output() sendTrainer : EventEmitter<Trainer> = new EventEmitter<Trainer>();

  chooseTrainer() {
    this.sendTrainer.emit(this.trainer);
  }
}
