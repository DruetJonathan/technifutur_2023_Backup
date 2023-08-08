import { Injectable } from '@angular/core';
import { product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ManageShoppingListService {
  productList: product[] = [];

  constructor() { }
  add(product: product): void {
    if (product.productName.trim() != "") {
      let resultOfFind: product | undefined = this.productList.find(p => product.productName.trim().toLowerCase() === p.productName.toLowerCase())
      !resultOfFind ? this.productList.push(product) : resultOfFind.quantity++;
    }

  }
  down(product: product | undefined) {
    (product && product.quantity > 1) ? product.quantity -= 1 : this.delete(product);
  }
  delete(index: any) {
    this.productList.splice(index, 1);
  }
  up(product: product | undefined) {
    if (product) {
      product.quantity++;
    }
  }
  getAll(): product[] | any {
    return this.productList;
  }
}
