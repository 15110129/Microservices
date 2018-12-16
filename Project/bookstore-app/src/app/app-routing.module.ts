import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ProductComponent} from './product/product.component';
import {CartComponent} from './cart/cart.component';
import {CategoryItemComponent} from './category-item/category-item.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {AdminComponent} from './admin/admin.component';
import {CreateComponent} from './create/create.component';
import {UpdateComponent} from './update/update.component';

const routes: Routes = [
  {path: 'product/update/:id', component: UpdateComponent},
  {path: 'product/create', component: CreateComponent},
  {path: 'admin', component: AdminComponent},
  {path: 'product/:id', component: ProductDetailComponent},
  {path: 'category/:id', component: CategoryItemComponent},
  {path: 'cart', component: CartComponent},
  {path: 'signup', component: RegisterComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: ProductComponent},
  {path: 'signin', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
