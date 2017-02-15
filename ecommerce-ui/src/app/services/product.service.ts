import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Product } from '../model/product';
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

  save(product: Product) : Observable<Response>{
    console.log(" product to save " + JSON.stringify(product));
    return this.http
      .post(this.baseUrl + "/products", JSON.stringify(product));
  }

}
