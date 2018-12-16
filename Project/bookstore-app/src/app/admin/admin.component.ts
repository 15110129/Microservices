import {Component, OnInit} from '@angular/core';
import {ProductService} from '../service/product.service';
import {Product} from '../model/product';
import {Location} from '@angular/common';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  products: Product[] = new Array();

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts(): void {
    this.products = new Array();
    this.productService.getProducts()
      .subscribe(res => {
        if (res.code === 1) {
          this.products = res.data;
          console.log(res.data);
        }
      });
  }

  deleteProduct(id: number): void {
    if (confirm('Bạn chắc chắn là muốn xóa?')) {
      this.productService.deleteProductById(id)
        .subscribe(res => {
          if (res.code !== -1) {
            console.log('Success');
          } else {
            console.log('Fail');
          }
        });
    }
  }
}
