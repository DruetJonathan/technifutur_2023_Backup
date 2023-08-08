import { Component } from '@angular/core';
import { product } from 'src/app/shared/models/product';

@Component({
  selector: 'app-exo2',
  templateUrl: './exo2.component.html',
  styleUrls: ['./exo2.component.scss']
})
export class Exo2Component {
  productList: product[] = [];
  productName: string = "";
  addProduct(): void {
    let productObject: product = {
      productName: this.productName.trim(),
      quantity: 1
    }
    if (this.productName.trim() != "") {
      let exist: boolean = false;
      let resultOfFind: product | undefined = this.productList.find(p => this.productName.trim().toLowerCase() === p.productName.toLowerCase())
      if (!resultOfFind) {
        this.productList.push(productObject)
      }
      else {
        resultOfFind.quantity++;
      }
    }

  }
  reduct(need: product) {
    let resultOfFind: product | undefined = this.productList.find(p => need === p);
    if (resultOfFind && resultOfFind.quantity > 1) {
      resultOfFind.quantity -= 1;
    }
    else {
      this.remove(need);
    }
  }
  remove(need: product) {
    let resultOfFind: number = this.productList.findIndex(p => p === need);
    this.productList.splice(resultOfFind, 1);
  }
  add(need: product) {
    let resultOfFind: product | undefined = this.productList.find(p => need === p);
    if (resultOfFind) {
      resultOfFind.quantity++;
    }
  }
}
