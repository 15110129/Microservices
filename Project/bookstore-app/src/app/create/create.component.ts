import {Component, OnInit} from '@angular/core';
import {AngularEditorConfig} from '@kolkov/angular-editor';
import {Prod} from '../model/prod';
import {CategoryService} from '../service/category.service';
import {Location} from '@angular/common';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  categories: any;
  prod: Prod = {
    id: 0,
    idCategory: 0,
    productName: '',
    price: 0,
    author: '',
    desc: '',
    productPicture: '',
    active: true
  };
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

  constructor(private categoryService: CategoryService,
              private productService: ProductService,
              private location: Location) {
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories()
      .subscribe(res => {
        if (res.code === 1) {
          this.categories = res.data;
        }
      });
  }

  btnHuy(): void {
    if (confirm('Bạn muốn hủy?')) {
      this.location.back();
    }
  }

  btnThem(): void {
    if (confirm('Bạn muốn thêm sách mới?')) {
      this.productService.createProduct(this.prod).subscribe(res => {
        if (res.code !== -1) {
          console.log('success');
        } else {
          console.log('failed');
        }
      });
      this.location.back();
    }
  }
}
