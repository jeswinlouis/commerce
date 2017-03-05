import { Country } from './country';

export class CreateProduct {

    sku: string;
    name: string;
    description: string;
    amount: string | number;
    country: string | number ;
    store: string | number;
    category: string | number;

}

export class Product {
    id: string | number;
    sku: string;
    name: string;
    description: string;
    amount: string | number;
    country: string | number ;
    store: string | number;
    category: string | number;

}