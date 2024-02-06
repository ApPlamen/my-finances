import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PaymentViewModel } from '../viewmodels/payment.viewmodel';

const CONTROLER_URL = 'payments';
const BASE_URL = environment.apiUrl + CONTROLER_URL;

@Injectable({
  providedIn: 'root'
})
export class PaymentsService {
  constructor(private http: HttpClient) { }

  getPaymentsBoard(): Observable<PaymentViewModel[]> {
    return this.http.get<PaymentViewModel[]>(BASE_URL + '/get-all');
  }

  // getPayment(userId: number): Observable<CreateEditUserModel> {
  //   return this.http.get<CreateEditUserModel>(BASE_URL + '/get-edit/' + userId);
  // }

  // savePayment(model: CreateEditUserModel): Observable<void> {
  //   return this.http.post<void>(BASE_URL + '/create-edit-user', model);
  // }

  deletePayment(userId: string): Observable<void> {
    return this.http.delete<void>(BASE_URL + '/' + userId);
  }
}
