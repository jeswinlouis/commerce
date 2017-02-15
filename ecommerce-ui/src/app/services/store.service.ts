import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Store } from '../model/store';
import 'rxjs/Rx';

@Injectable()
export class StoreService {
  private baseUrl: string = '/commerce';

  constructor(private http : Http){
  }

  getAll(): Observable<Store[]>{
    let store$ = this.http
      .get(this.baseUrl+"/stores")
      .map(res => res.json().content);
      return store$;
  }
}
