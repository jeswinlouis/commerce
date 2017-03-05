import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CreateProduct } from '../model/product';
import { Country } from '../model/country';
import { Category } from '../model/category';
import { Store } from '../model/store';
import { ProductService } from '../services/product.service';

import { CountryService } from '../services/country.service';
import { StoreService } from '../services/store.service';
import { CategoryService } from '../services/category.service';



@Component({
    selector: 'product-form',
    templateUrl: './product-form.component.html',
    styleUrls: ['./product-form.component.css']

})
export class ProductFormComponent implements OnInit {

    countries: Country[];
    stores: Store[];
    categories: Category[];


    constructor(
        private productService: ProductService,
        private countryService: CountryService, 
        private storeService: StoreService, 
        private categoryService: CategoryService) {}



    ngOnInit() {

        this.countryService.getAll().subscribe (
            countries => this.countries = countries);

        this.storeService.getAll().subscribe (
            stores => this.stores = stores);

        this.categoryService.getAll().subscribe (
            categories => this.categories = categories);

 

    }

    @Output() productCreated = new EventEmitter();

    newProduct: CreateProduct = new CreateProduct();
    active: boolean = true;


    onSubmit() {

        this.productService.save(this.newProduct);

        this.productCreated.emit( { product: this.newProduct });
        this.newProduct = new CreateProduct();

        this.active = false;
        setTimeout(() => 
            this.active = true, 0

        );
        

    }
}