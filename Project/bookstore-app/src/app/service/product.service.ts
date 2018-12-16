import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RestResponse} from '../model/RestResponse';
import {Observable} from 'rxjs';
import {Prod} from '../model/prod';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productUrl = '/products/';

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<RestResponse> {
    return this.http.get<RestResponse>(this.productUrl + 'product');
  }

  getProduct(id: number): Observable<RestResponse> {
    const url = `${this.productUrl + 'product/category'}/${id}`;
    return this.http.get<RestResponse>(url);
  }

  getProductByIdProduct(id: number): Observable<RestResponse> {
    const url = `${this.productUrl + 'product'}/${id}`;
    console.log(url);
    return this.http.get<RestResponse>(url);
  }

  createProduct(prod: Prod): Observable<RestResponse> {
    return this.http.post<RestResponse>(this.productUrl + 'product', prod);
  }

  updateProduct(id: number, prod: Prod): Observable<RestResponse> {
    return this.http.put<RestResponse>(this.productUrl + 'product/' + id, prod);
  }

  deleteProductById(id: number): Observable<RestResponse> {
    return this.http.delete<RestResponse>(this.productUrl + 'product/' + id);
  }
}
