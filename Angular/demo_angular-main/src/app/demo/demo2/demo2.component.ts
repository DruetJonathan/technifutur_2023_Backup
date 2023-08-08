import { Component } from '@angular/core';

@Component({
  selector: 'app-demo2',
  templateUrl: './demo2.component.html',
  styleUrls: ['./demo2.component.scss']
})
export class Demo2Component {
    maChaine : string = "Ma super chaine";

    monNombre : number = 42.5484885687;
    
    dateDuJour : Date = new Date();

    temperature : number = 18;
}
