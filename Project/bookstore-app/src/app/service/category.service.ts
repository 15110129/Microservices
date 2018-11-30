import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RestResponse} from '../model/RestResponse';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private productUrl = '/product/';

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<RestResponse> {
    return this.http.get<RestResponse>(this.productUrl + 'category');
  }

  getCategory(id: number): Observable<RestResponse> {
    const url = `${this.productUrl + 'category'}/${id}`;
    return this.http.get<RestResponse>(url);
  }
}
