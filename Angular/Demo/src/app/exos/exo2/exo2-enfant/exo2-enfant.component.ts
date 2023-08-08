import { Component, EventEmitter, Input, Output } from '@angular/core';
import { product } from 'src/app/shared/models/product';

@Component({
  selector: 'app-exo2-enfant',
  templateUrl: './exo2-enfant.component.html',
  styleUrls: ['./exo2-enfant.component.scss']
})
export class Exo2EnfantComponent {
  @Input() productList: product[] = [];

  @Output() reductOutput: EventEmitter<product> = new EventEmitter<product>();
  @Output() addOutput: EventEmitter<product> = new EventEmitter<product>();
  @Output() removeOutput: EventEmitter<product> = new EventEmitter<product>();

  reduct(need: product) {
    this.reductOutput.emit(need);
  }
  remove(need: product) {
    this.removeOutput.emit(need);
  }
  add(need: product) {
    this.addOutput.emit(need);
  }
}
