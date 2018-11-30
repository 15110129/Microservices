import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RestResponse} from '../model/RestResponse';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productUrl = '/product/';

  constructor(private http: HttpClient) {
  }

  getProducts(): Observable<RestResponse> {
    return this.http.get<RestResponse>(this.productUrl + 'product');
  }

  getProduct(id: number): Observable<RestResponse> {
    const url = `${this.productUrl + 'product/category'}/${id}`;
    return this.http.get<RestResponse>(url);
  }
}
