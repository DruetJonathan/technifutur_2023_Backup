import { Injectable } from '@angular/core';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ShoppingService {

  private _productList : Product[] = [
    { id : 1, name : 'Banane', quantity : 2 },
    { id : 2, name : 'Chocolat', quantity : 5 }
  ]

  constructor() { }

  getAll() : Product[] {
    return this._productList;
  }

  add(name : string) : void {
     if( name.trim() != "" ){
      let searchProduct = this._productList.find(p => p.name.trim().toLowerCase() == name.trim().toLowerCase());
      
      if(searchProduct){
        searchProduct.quantity++;
      }
      else{
        let nextId = Math.max(...this._productList.map(p => p.id)) + 1;
    
        let productToAdd : Product = { id : nextId, name : name, quantity : 1};
        
        this._productList.push(productToAdd);
      }
    }
  }

  upQty(id : number) : void {
    let product = this._productList.find(p => p.id === id);
    if(product) {
      product.quantity++;
    }
  }

  downQty(id : number) : void {
    let product = this._productList.find(p => p.id === id);
    if(product) {
      product.quantity--;
      if(product.quantity === 0) {
        this.delete(id);
      }
    }
  }

  delete(id : number) : void {
    this._productList = this._productList.filter(p => p.id !== id)  

  }
}
