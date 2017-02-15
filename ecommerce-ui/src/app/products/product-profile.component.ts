import { Component, Input } from '@angular/core';

import { Product } from '../model/product';


@Component({

    selector: 'product-profile',
    templateUrl: './product-profile.component.html'

})
export class ProductProfileComponent {
    @Input() product: Product;




}