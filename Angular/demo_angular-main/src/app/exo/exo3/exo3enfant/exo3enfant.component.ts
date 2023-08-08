import { Component } from '@angular/core';
import { Product } from 'src/app/shared/models/product';
import { ShoppingService } from 'src/app/shared/services/shopping.service';

@Component({
  selector: 'app-exo3enfant',
  templateUrl: './exo3enfant.component.html',
  styleUrls: ['./exo3enfant.component.scss']
})
export class Exo3enfantComponent {
  // listToShow : Product[] = this._shopListS.getAll();

  constructor(private _shopListS : ShoppingService) {

  }

  getAll() {
    return this._shopListS.getAll();
  }

  up( id:  number) {
    this._shopListS.upQty(id);
  }

  down( id : number ) {
    this._shopListS.downQty(id);
    // this.listToShow = this._shopListS.getAll();
  }

  delete( id : number ) {
    this._shopListS.delete(id);
    // this.listToShow = this._shopListS.getAll();
  }
}
