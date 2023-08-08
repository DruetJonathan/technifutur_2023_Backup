import { Component } from '@angular/core';
import { product } from 'src/app/shared/models/product';
import { ManageShoppingListService } from 'src/app/shared/services/manage-shopping-list.service';

@Component({
  selector: 'app-exo3',
  templateUrl: './exo3.component.html',
  styleUrls: ['./exo3.component.scss']
})
export class Exo3Component {

  productList: product[] = this._manageShoppingS.getAll();
  productName: string = "";

  constructor(private _manageShoppingS: ManageShoppingListService) { }
  add(productName: string): void {
    this._manageShoppingS.add({
      productName: this.productName.trim(),
      quantity: 1
    });
    console.log('ok');
  }
}
