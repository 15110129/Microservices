import {Component, OnInit} from '@angular/core';

import {Product} from '../model/product';
import {ProductService} from '../service/product.service';
import {OrderDetail} from '../model/orderdetail';

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

  addLocalStorage(product: Product): void {
    let orderDetail: OrderDetail;
    orderDetail = new OrderDetail();

    if (!localStorage.getItem(product.id.toString())) {
      orderDetail.idProduct = product.id;
      orderDetail.unitPrice = product.price;
      orderDetail.quantity = 1;
      localStorage.setItem(product.id.toString(), JSON.stringify(orderDetail));
    } else {
      let myQuantity: any;
      myQuantity = JSON.parse(localStorage.getItem(product.id.toString()));
      let quantity: number;
      quantity = myQuantity.quantity + 1;
      orderDetail.idProduct = product.id;
      orderDetail.unitPrice = product.price;
      orderDetail.quantity = quantity;
      localStorage.setItem(product.id.toString(), JSON.stringify(orderDetail));
    }
  }
}
