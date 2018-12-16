import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AngularEditorModule} from '@kolkov/angular-editor';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {AppRoutingModule} from './app-routing.module';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ProductComponent} from './product/product.component';
import {CartComponent} from './cart/cart.component';
import {ProductItemComponent} from './product-item/product-item.component';
import {FooterComponent} from './footer/footer.component';
import {CategoryItemComponent} from './category-item/category-item.component';
import {ProductDetailComponent} from './product-detail/product-detail.component';
import {AdminComponent} from './admin/admin.component';
import {CreateComponent} from './create/create.component';
import { UpdateComponent } from './update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    RegisterComponent,
    ProductComponent,
    CartComponent,
    ProductItemComponent,
    FooterComponent,
    CategoryItemComponent,
    ProductDetailComponent,
    AdminComponent,
    CreateComponent,
    UpdateComponent
  ],
  imports: [
    AngularEditorModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
