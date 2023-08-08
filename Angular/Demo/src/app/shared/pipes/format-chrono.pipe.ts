import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatChrono'
})
export class FormatChronoPipe implements PipeTransform {

  transform(value: number): string {
    let min: number = Math.floor(value / 60)
    return `${min} minutes ${value % 60} secondes`;
  }

}
