import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../service/category.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  categories: any;

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories()
      .subscribe(res => {
        if (res.code === 1) {
          this.categories = res.data;
          console.log(res.data);
        }
      });
  }
}
