import { Component } from '@angular/core';
import { product } from 'src/app/shared/models/product';
import { ManageShoppingListService } from 'src/app/shared/services/manage-shopping-list.service';

@Component({
  selector: 'app-exo3-enfant',
  templateUrl: './exo3-enfant.component.html',
  styleUrls: ['./exo3-enfant.component.scss']
})
export class Exo3EnfantComponent {
  constructor(private _manageShoppingS: ManageShoppingListService) { }
  productName: string = "";
  productList: product[] = this._manageShoppingS.getAll();

  up(product: product): void {
    this._manageShoppingS.up(this.productList.find(p => product === p));
  }
  down(product: product): void {
    this._manageShoppingS.down(this.productList.find(p => product === p));

  }
  delete(product: product): void {
    this._manageShoppingS.delete(this.productList.findIndex(p => p === product));
  }
}
