import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PaymentViewModel } from '../viewmodels/payment.viewmodel';
import { PaymentModel } from '../models/payment.model';

const CONTROLER_URL = 'payments';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class PaymentsService {
  constructor(private http: HttpClient) { }

  getPaymentsBoard(): Observable<PaymentViewModel[]> {
    return this.http.get<PaymentViewModel[]>(BASE_URL + '/board');
  }

  getPayment(paymentId: number): Observable<PaymentModel> {
    return this.http.get<PaymentModel>(BASE_URL + '/get/' + paymentId);
  }

  savePayment(model: PaymentModel): Observable<void> {
    if(model.id != null){
      return this.http.put<void>(BASE_URL + '/update', model);
    }

    return this.http.post<void>(BASE_URL + '/create', model);
  }

  deletePayment(paymentId: string): Observable<void> {
    return this.http.delete<void>(BASE_URL + '/delete/' + paymentId);
  }
}
