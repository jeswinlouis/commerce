import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ProductProfileComponent } from './products/product-profile.component';
import { ProductFormComponent } from './products/product-form.component';
import { ProductService } from './services/product.service';
import { CountryService } from './services/country.service';
import { StoreService } from './services/store.service';

import { CategoryService } from './services/category.service';



@NgModule({
  declarations: [
    AppComponent,
    ProductProfileComponent,
    ProductFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [ProductService, CountryService, StoreService, CategoryService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
