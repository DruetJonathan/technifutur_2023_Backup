import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'toFarenheit'
})
export class ToFarenheitPipe implements PipeTransform {

  transform(value: number): number {
    //value : La valeur à gauche du signe pipe : celle qui doit être transformée
    //type de retour : la valeur après transformation
    return ( value * 9/5) + 32 ;
  }

}
