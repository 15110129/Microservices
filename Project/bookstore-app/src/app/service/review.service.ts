import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {RestResponse} from '../model/RestResponse';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private reviewURL = '/review/';

  constructor(private http: HttpClient) {
  }

  getReview(id: number): Observable<RestResponse> {
    const url = `${this.reviewURL + 'product'}/${id}`;
    return this.http.get<RestResponse>(url);
  }
}
