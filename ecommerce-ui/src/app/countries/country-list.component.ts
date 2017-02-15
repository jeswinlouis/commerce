import {Component, NgModule} from '@angular/core'
import {BrowserModule} from '@angular/platform-browser'
import { Country } from '../model/country';
 
@Component({
  selector: 'country-list',
  templateUrl: './country-list.component.html'
})
export class CountryListComponent {
  selectedCountry:Country = new Country(2, 'India');
  countries = [
     new Country(1, 'USA' ),
     new Country(2, 'India' ),
     new Country(3, 'Australia' ),
     new Country(4, 'Brazil')
  ];
}