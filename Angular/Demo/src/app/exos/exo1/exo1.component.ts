import { Component } from '@angular/core';

@Component({
  selector: 'app-exo1',
  templateUrl: './exo1.component.html',
  styleUrls: ['./exo1.component.scss']
})
export class Exo1Component {
  isActive: boolean = true
  chronoNumber: number = 0;
  chrono: any = undefined;

  start(): void {
    this.isActive = false;
    this.chrono = setInterval(() => {
      this.chronoNumber++;
    }, 1000);

  }
  pause(): void {
    clearInterval(this.chrono);
    this.chrono = undefined;

  }
  reset(): void {
    this.chronoNumber = 0;
    this.pause();
  }
}
