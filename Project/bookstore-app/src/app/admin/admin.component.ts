import {Component, OnInit} from '@angular/core';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  products: any;

  constructor(private productService: ProductService) {
  }

  ngOnInit() {
    this.getProducts();
  }

  getProducts(): void {
    this.productService.getProducts()
      .subscribe(res => {
        if (res.code === 1) {
          this.products = res.data;
          console.log(res.data);
        }
      });
  }
}
