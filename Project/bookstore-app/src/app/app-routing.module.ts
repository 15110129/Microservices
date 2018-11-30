import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ProductComponent} from './product/product.component';
import {CartComponent} from './cart/cart.component';
import {CategoryItemComponent} from './category-item/category-item.component';

const routes: Routes = [
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
