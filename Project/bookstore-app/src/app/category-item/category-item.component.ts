import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CategoryService} from '../service/category.service';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {OrderDetail} from '../model/orderdetail';

@Component({
  selector: 'app-category-item',
  templateUrl: './category-item.component.html',
  styleUrls: ['./category-item.component.css']
})

export class CategoryItemComponent implements OnInit {
  products: any;
  category: any;

  constructor(private route: ActivatedRoute,
              private productService: ProductService,
              private categoryService: CategoryService) {
    route.params.subscribe(_ => {
      this.getCategoryByIdCategory();
      this.getProductByIdCategory();
    });
  }

  ngOnInit() {
    this.getCategoryByIdCategory();
    this.getProductByIdCategory();
  }

  getCategoryByIdCategory(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.categoryService.getCategory(id)
      .subscribe(res => {
        if (res.code === 1) {
          this.category = res.data;
          console.log(res.data);
        }
      });
  }

  getProductByIdCategory(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.productService.getProduct(id)
      .subscribe(res => {
        if (res.code === 1) {
          this.products = res.data;
          console.log(res.data);
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
