import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Country } from '../model/country';
import 'rxjs/Rx';

@Injectable()
export class CountryService {
  private baseUrl: string = '/commerce';

  constructor(private http : Http){
  }

  getAll(): Observable<Country[]>{
    let country$ = this.http
      .get(this.baseUrl+"/countries")
      .map(res => res.json().content);

      console.log("countries " + country$);
      return country$;
  }
}
