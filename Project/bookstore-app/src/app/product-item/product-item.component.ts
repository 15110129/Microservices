import {Component, OnInit} from '@angular/core';

import {Product} from '../model/product';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
  productsHot: any;
  productsIT: any;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProductsHot();
    this.getProductsIT();
  }

  getProductsHot(): void {
    this.productService.getProducts()
      .subscribe(res => {
        if (res.code === 1) {
          this.productsHot = res.data.slice(6, 14);
          console.log(res.data);
        }
      });
  }

  getProductsIT(): void {
    this.productService.getProducts()
      .subscribe(res => {
        if (res.code === 1) {
          this.productsIT = res.data.slice(13, 17);
        }
      });
  }
}
