import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Category } from '../model/category';
import 'rxjs/Rx';

@Injectable()
export class CategoryService {
  private baseUrl: string = '/commerce';

  constructor(private http : Http){
  }

  getAll(): Observable<Category[]>{
    let category$ = this.http
      .get(this.baseUrl+"/categories")
      .map(res => res.json().content);

      console.log("categories " + category$);
      return category$;
  }
}
