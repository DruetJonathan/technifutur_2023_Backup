import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertTemp'
})
export class ConvertTempPipe implements PipeTransform {

  transform(value: number, metric: string): number {
    switch(metric) {
      case "fToCelcius" :
        return (value  - 32 ) * 5/9;
      case "cToFarenheit" : 
        return (value * 9/5 ) + 32;
      case "cToKelvin" :
        return value + 273.15;
      case "fToKelvin" :
        return (value - 32) * 5/9 + 273.15;
      default :
        return value;
    }

  }

}
