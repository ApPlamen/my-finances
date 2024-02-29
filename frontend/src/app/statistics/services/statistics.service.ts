import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ChangeByDateFilterModel } from '../models/change-by-date-filter.model';
import { SpentByVendorFilterModel } from '../models/spent-by-vendor-filter..model';

const CONTROLER_URL = 'statistics';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  constructor(private http: HttpClient) { }

  getChangeByDate(value: ChangeByDateFilterModel): Observable<any[]> {
    return this.http.post<any[]>(BASE_URL + '/change-by-date', value);
  }

  getSpentByVendor(value: SpentByVendorFilterModel): Observable<any[]> {
    return this.http.post<any[]>(BASE_URL + '/spent-by-vendor', value);
  }

}
