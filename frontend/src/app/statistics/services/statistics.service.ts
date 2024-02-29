import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ChangeByDateFilterModel } from '../models/change-by-date-filter.model';
import { SpentByVendorFilterModel } from '../models/spent-by-vendor-filter.model';
import { KeyValuePair } from '../viewmodels/key-value-pair.viewmodel';
import { ListOfKeyValuePairs } from '../viewmodels/list-of-key-value-pairs.viewmodel';

const CONTROLER_URL = 'statistics';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {
  constructor(private http: HttpClient) { }

  getChangeByDate(value: ChangeByDateFilterModel): Observable<ListOfKeyValuePairs[]> {
    return this.http.post<ListOfKeyValuePairs[]>(BASE_URL + '/change-by-date', value);
  }

  getSpentByVendor(value: SpentByVendorFilterModel): Observable<KeyValuePair[]> {
    return this.http.post<KeyValuePair[]>(BASE_URL + '/spent-by-vendor', value);
  }

  getSpentByVendorByPaymentOption(value: SpentByVendorFilterModel): Observable<ListOfKeyValuePairs[]> {
    return this.http.post<ListOfKeyValuePairs[]>(BASE_URL + '/spent-by-vendor-by-payment-option', value);
  }
}
