import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertTime'
})
export class ConvertTimePipe implements PipeTransform {

  transform(value: number, format : string): string {
    let minutes : number = Math.floor(value / 60);
    let seconds : number = value % 60;

    if(format === "long") {
      return ` ${minutes} minute${minutes < 10 ? '' : 's'} ${seconds} seconde${ seconds < 10 ? '' : 's'}`;
    }
    if (format === "short") {
      return `${minutes < 10 ? '0' : ''}${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
    }
    else {
      return '';
    }
  }

}
