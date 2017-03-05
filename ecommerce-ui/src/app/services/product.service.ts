import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Product, CreateProduct } from '../model/product';
import 'rxjs/Rx';

@Injectable()
export class ProductService {
  private baseUrl: string = '/commerce';

  constructor(private http : Http){
  }

  getAll(): Observable<Product[]>{
    let product$ = this.http
      .get(this.baseUrl+"/products")
      .map(res => res.json().content);
      return product$;
  }

  save(product: CreateProduct) : Observable<Product>{
    console.log(" product to save " + JSON.stringify(product));
    let productResponse$ = this.http
      .post(this.baseUrl + "/products", product).map((response:Response) => response.json());

      console.log("the response " + JSON.stringify(productResponse$));
      return productResponse$;

  }

}
