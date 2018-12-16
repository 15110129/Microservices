import {Component, OnInit} from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {OrderDetail} from '../model/orderdetail';
import {forEach} from '@angular/router/src/utils/collection';
import {componentRefresh} from '@angular/core/src/render3/instructions';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  product: Product = new Product();
  products: Product[] = new Array();
  total: number;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getListOrderDetail();
    this.totalPrice();
  }

  getListOrderDetail(): void {

    for (let i = 0; i < localStorage.length; i++) {
      const key = localStorage.key(i);
      const value = JSON.parse(localStorage.getItem(key));
      const id = value.idProduct;
      this.products = new Array();
      this.productService.getProductByIdProduct(id)
        .subscribe(res => {
          if (res.code === 1) {
            res.data.quantity = [(value.quantity)];
            this.products.push(res.data);
          }
        });
    }
  }

  onClick(product: Product): void {
    let orderDetail: OrderDetail;
    orderDetail = new OrderDetail();
    orderDetail.idProduct = product.id;
    orderDetail.unitPrice = product.price;
    orderDetail.quantity = product.quantity;
    localStorage.setItem(product.id.toString(), JSON.stringify(orderDetail));
    this.totalPrice();
  }

  totalPrice(): void {
    this.total = 0;
    for (let i = 0; i < localStorage.length; i++) {
      const key = localStorage.key(i);
      const value = JSON.parse(localStorage.getItem(key));
      this.total += value.unitPrice * value.quantity;
    }
  }
  delete(product: Product): void {
    localStorage.removeItem(product.id.toString());
    this.getListOrderDetail();
    this.totalPrice();
  }
}
