import { Component, OnInit } from '@angular/core';
import { ProductService } from './services/product.service';

import { Product } from './model/product';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  products: Product[];


  constructor(public productService: ProductService) {}


  ngOnInit() {

    this.productService.getAll().subscribe (
    products => this.products = products);

    


  }
  title = 'app works!';

  // products: Product[] = [
  //   { id: 1, name: 'p1', description: 'p1'},
  //   { id: 2, name: 'p2', description: 'p2'},
  //   { id: 3, name: 'p3', description: 'p3'},
  //   { id: 4, name: 'p4', description: 'p4'}
  // ]

  activeProduct: Product;

  selectedProduct(product) {

    this.activeProduct = product;
    console.log(this.activeProduct);

  }

  onProductCreated(event) {
      this.products.push(event.product);

  }
}
