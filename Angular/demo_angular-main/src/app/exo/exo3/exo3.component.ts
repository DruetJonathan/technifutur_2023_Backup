import { Component } from '@angular/core';
import { ShoppingService } from 'src/app/shared/services/shopping.service';

@Component({
  selector: 'app-exo3',
  templateUrl: './exo3.component.html',
  styleUrls: ['./exo3.component.scss']
})
export class Exo3Component {
    productName : string = "";

    constructor(private _shoppingService : ShoppingService) {

    }

    add() {
      this._shoppingService.add(this.productName);
      this.productName = "";
    }
}
