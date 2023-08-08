import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Product } from 'src/app/shared/models/product';

@Component({
  selector: 'app-exo2enfant',
  templateUrl: './exo2enfant.component.html',
  styleUrls: ['./exo2enfant.component.scss']
})
export class Exo2enfantComponent {
  @Input() listToShow : Product[] = [];

  @Output() deleteEvent : EventEmitter<number> = new EventEmitter<number>();

  @Output() downEvent : EventEmitter<number> = new EventEmitter<number>();

  @Output() upEvent : EventEmitter<number> = new EventEmitter<number>();

  sendDeleteEvent(id : number) : void {
    this.deleteEvent.emit(id);
  }

  sendDownEvent(id : number ) : void {
    this.downEvent.emit(id);
  }

  sendUpEvent(id : number) : void {
    this.upEvent.emit(id);
  }
}
