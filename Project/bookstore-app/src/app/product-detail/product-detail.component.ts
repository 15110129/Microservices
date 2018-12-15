import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../service/product.service';
import {Location} from '@angular/common';
import {Product} from '../model/product';
import {OrderDetail} from '../model/orderdetail';
import {ReviewService} from '../service/review.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  product: any;
  reviews: any;

  constructor(private route: ActivatedRoute,
              private productService: ProductService,
              private reviewService: ReviewService) {
    route.params.subscribe(_ => {
      this.getProductById();
      this.getReview();
    });
  }

  ngOnInit() {
    this.getProductById();
    this.getReview();
  }

  getProductById(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.productService.getProductByIdProduct(id)
      .subscribe(res => {
        if (res.code === 1) {
          this.product = res.data;
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

  getReview(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reviewService.getReview(id)
      .subscribe(res => {
        if (res.code === 1) {
          this.reviews = res.data;
          console.log(res.data);
        }
      });
  }
}
