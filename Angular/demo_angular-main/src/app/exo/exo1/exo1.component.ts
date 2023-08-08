import { Component } from '@angular/core';

@Component({
  selector: 'app-exo1',
  templateUrl: './exo1.component.html',
  styleUrls: ['./exo1.component.scss']
})
export class Exo1Component {

  seconds : number = 0;
  timer : any = undefined;

  start() : void {
    this.timer = setInterval(() => {
      this.seconds++;
    }, 1000)
  }

  pause() : void {
    clearInterval(this.timer);
    this.timer = undefined;
  }

  reset() : void {
    this.seconds = 0;
    this.pause();
  }
}
