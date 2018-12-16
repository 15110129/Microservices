import {Component, OnInit} from '@angular/core';
import {AngularEditorConfig} from '@kolkov/angular-editor';
import {Prod} from '../model/prod';
import {CategoryService} from '../service/category.service';
import {Location} from '@angular/common';
import {ProductService} from '../service/product.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  categories: any;
  cate: any;
  // prod: Prod = {
  //   id: 0,
  //   idCategory: 0,
  //   productName: '',
  //   price: 0,
  //   author: '',
  //   desc: '',
  //   productPicture: '',
  //   active: true
  // };
  prod: any;
  config: AngularEditorConfig = {
    editable: true,
    height: '15rem',
    minHeight: '5rem',
    placeholder: 'Mô tả sách...',
    translate: 'no',
    customClasses: [
      {
        name: 'quote',
        class: 'quote',
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: 'titleText',
        class: 'titleText',
        tag: 'h1',
      },
    ]
  };

  constructor(private route: ActivatedRoute,
              private categoryService: CategoryService,
              private productService: ProductService,
              private location: Location) {
  }

  ngOnInit() {
    this.getProductById();
    this.getCategories();
  }

  getProductById(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.productService.getProductByIdProduct(id)
      .subscribe(res => {
        if (res.code === 1) {
          this.prod = res.data;
        }
      });
  }

  getCategories(): void {
    this.categoryService.getCategories()
      .subscribe(res => {
        if (res.code === 1) {
          this.categories = res.data;
        }
      });
  }

  btnLuu(): void {
    if (confirm('Bạn muốn lưu lại?')) {
      this.productService.updateProduct(this.prod.id, this.prod)
        .subscribe(res => {
          if (res.code !== -1) {
            console.log('success');
          } else {
            console.log('failed');
          }
        });
    }
    this.location.back();
  }

  btnHuy(): void {
    if (confirm('Bạn muốn hủy?')) {
      this.location.back();
    }
  }
}
