import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Dropdown } from 'src/app/shared/models/dropdown.model';

const CONTROLER_URL = 'payment-options';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class PaymentOptionsService {
  constructor(private http: HttpClient) { }

  getPaymentOptions(): Observable<Dropdown[]> {
    return this.http.get<Dropdown[]>(BASE_URL + '/options');
  }
}
