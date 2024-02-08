import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PaymentBoardViewModel } from '../viewmodels/payment-board.viewmodel';
import { CreateEditPaymentModel } from '../models/create-edit-payment.model';

const CONTROLER_URL = 'payments';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class PaymentsService {
  constructor(private http: HttpClient) { }

  getPaymentsBoard(): Observable<PaymentBoardViewModel[]> {
    return this.http.get<PaymentBoardViewModel[]>(BASE_URL + '/board');
  }

  getEditPayment(paymentId: number): Observable<CreateEditPaymentModel> {
    return this.http.get<CreateEditPaymentModel>(BASE_URL + '/get-edit/' + paymentId);
  }

  saveEditPayment(model: CreateEditPaymentModel): Observable<void> {
    return this.http.post<void>(BASE_URL + '/create-edit-payment', model);
  }

  deletePayment(paymentId: string): Observable<void> {
    return this.http.delete<void>(BASE_URL + '/delete/' + paymentId);
  }
}
