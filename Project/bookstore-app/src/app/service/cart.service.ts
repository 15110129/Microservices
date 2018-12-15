import {Injectable} from '@angular/core';
import {OrderDetail} from '../model/orderdetail';
import {Observable, ObservableInput, of} from 'rxjs';
import {Product} from '../model/product';
import {forEach} from '@angular/router/src/utils/collection';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  orderDetail: OrderDetail[];
  order: OrderDetail;

  constructor() {
  }

  getOrderDetail(): OrderDetail[] {
    return this.orderDetail;
  }

  addOrderDetail(product: Product): void {
    this.order.idProduct = product.id;
    this.order.unitPrice = product.price;
    this.order.quantity = 1;
    this.orderDetail.push(this.order);
  }

  updateOrderDetail(product: Product): void {
    for (let i = 0; i < this.orderDetail.length; i++) {
      if (this.orderDetail[i].idProduct === product.id) {
        this.orderDetail[i].quantity += 1;
      }
    }

  }

  deleteOrderDetail(product: Product): void {
    const index = this.orderDetail.findIndex(od => od.idProduct === product.id);
    this.orderDetail.splice(index, 1);
  }
}
