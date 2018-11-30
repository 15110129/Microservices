import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute, ParamMap} from '@angular/router';
import {Location} from '@angular/common';
import {CategoryService} from '../service/category.service';
import {ProductService} from '../service/product.service';

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
}
